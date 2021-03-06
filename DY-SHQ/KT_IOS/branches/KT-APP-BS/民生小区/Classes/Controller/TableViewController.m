//
//  TableViewController.m
//  民生小区
//
//  Created by L on 15/4/13.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import "TableViewController.h"
#import "MSWaterSendingCell.h"
#import "WaterSending.h"
#import "MBProgressHUD.h"
#import "KTFooterView.h"
#import "AFNetworking.h"
#import "EHNetwork.h"
#import "MJRefresh.h"
#import "KTWaterDetailsViewController.h"
//#import "MJExtension.h"
//#import "CartList.h"

#import "ErrorMessage.h"

#import "LBModel.h"
#import "BSTestInTransfer.h"
#import "BSFramework.h"
#import "BSInfrastructure.h"

#define Main_Screen_Height      [[UIScreen mainScreen] bounds].size.height
#define Main_Screen_Width       [[UIScreen mainScreen] bounds].size.width
//#define Url  @"http://192.168.1.103:8090/water/waterinformations/1/0/10"

@interface TableViewController ()

@property (nonatomic,strong)NSMutableArray *waterSendings;
//@property (nonatomic, strong) NSMutableArray *mDateArrayM; // 模型数组
@property (nonatomic, strong) EHNetwork *mNetwork;
@property (nonatomic, strong) UIView *mHintView;

@end

@implementation TableViewController

//1.懒加载
-(NSMutableArray *)waterSendings
{
    if (!_waterSendings)
        _waterSendings = [NSMutableArray array];
    
    return _waterSendings;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    
    
}

- (void)viewDidLoad {
    [super viewDidLoad];
 
    // 网络加载数据
    [self headerRereshing];
    
    
    [self setupRefresh];
    // 初始化网络请求
    self.mNetwork = [[EHNetwork alloc] init];

    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc]initWithTitle:@"返回" style:UIBarButtonItemStylePlain target:self action:@selector(backClick)];
}

/**
 *  集成刷新控件
 */
- (void)setupRefresh
{
    // 1.下拉刷新(进入刷新状态就会调用self的headerRereshing)
    [self.tableView addLegendHeaderWithRefreshingTarget:self
                                       refreshingAction:@selector(headerRereshing)];
    self.tableView.header.updatedTimeHidden = YES;
    [self.tableView.header beginRefreshing];
    
    // 2.上拉加载更多(进入刷新状态就会调用self的footerRereshing)
    [self.tableView addLegendFooterWithRefreshingTarget:self
                                       refreshingAction:@selector(footerRereshing)];
    [self.tableView.footer setTitle:@"已经是最后一条"
                           forState:MJRefreshFooterStateNoMoreData];
}

#pragma mark 开始进入刷新状态
- (void)headerRereshing
{

    //1.网络加载数据
    [self loadMoreData:[self firstDataId] dataCount:[self pageCount]];
    // 2.刷新表格UI
    [self.tableView reloadData];
    // 3. 结束刷新状态
    [self.tableView.header endRefreshing];
    //
    
}

- (void)footerRereshing
{
   
    //1.网络加载数据
    [self loadMoreData:self.lastDataId dataCount:10];
    
    // 2.刷新表格UI 刷新表格
    [self.tableView reloadData];
    
     // 3. 结束刷新状态
     [self.tableView.footer endRefreshing];
    
}


- (void)backClick
{
    [self dismissViewControllerAnimated:YES completion:nil];
}

#pragma mark ----- tableView的代理方法
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{  //加载的数据放在大数组里面,tableView有多少数据是靠这数组来算
    NSLog(@"%ld", (unsigned long)self.waterSendings.count);
    return self.waterSendings.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    
    MSWaterSendingCell *cell = [MSWaterSendingCell cellWithTableView:tableView];
    WaterSending *model = self.waterSendings[indexPath.row];
    cell.model = model;
    return cell;
}
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 110;
}

#pragma mark  ---  网络请求
- (void)initData
{
    [WaterSending
        listWaterList:0 dataCount:10
            blockArray:^(NSMutableArray *warters, NSError *error,ErrorMessage *errorMessage) {
                if (!error) {
                    NSArray *array = [self.waterSendings arrayByAddingObjectsFromArray:warters];
                    self.waterSendings = (NSMutableArray *)array;
                    [self.tableView reloadData];
                    [MBProgressHUD hideHUDForView:self.tableView animated:YES ];
                     // 关闭刷新提示
                    [self.tableView.footer endRefreshing];
                }

            }
     ];
}

#pragma mark  ---  网络请求
- (void)loadMoreData:(long) warterId dataCount:(int)cellCount
{
    
    [WaterSending
     listWaterList:warterId dataCount:cellCount
     blockArray:^(NSMutableArray *warters, NSError *error,ErrorMessage *errorMessage) {
         if (!error) {
             [self.waterSendings addObjectsFromArray:warters];
         }
         if (errorMessage) {
              NSLog(@"已经是最后一条数据");
             [self.tableView.footer noticeNoMoreData];
         }
       }
    ];
    
    
}

// 点击某一行，进入产品详细页
- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
     UIStoryboard *storyboard = [UIStoryboard storyboardWithName:@"KTWaterDetailsViewController" bundle:nil];
    KTWaterDetailsViewController *login2 = [storyboard instantiateInitialViewController];
    login2.waterSending = self.waterSendings[indexPath.row];
    [self.navigationController pushViewController:login2 animated:YES];
    
    
}

-(long )firstDataId{
   WaterSending *ws=[self.waterSendings firstObject];
    return ws.id;
}

-(long )lastDataId{
    WaterSending *ws=[self.waterSendings lastObject];
    return ws.id;
}
-(int )pageCount{
     return 10;
}

- (void)dealloc

{
     NSLog(@"TableView dealloc");
    [self.tableView removeHeader ];
    
    [self.tableView removeFooter];
    
}

@end
