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
#import "MBProgressHUD+NJ.h"
#import "KTFooterView.h"
#import "MSWaterSendingCell.h"
#import "AFNetworking.h"
#import "EHNetwork.h"
#import "MJRefresh.h"
#import "NewPruVcViewController.h"
#import "MJExtension.h"

#define Main_Screen_Height      [[UIScreen mainScreen] bounds].size.height
#define Main_Screen_Width       [[UIScreen mainScreen] bounds].size.width
#define Url  @"http://192.168.2.103:8090/water/waterinformations/1/0/10"

@interface TableViewController ()

@property (nonatomic,strong)NSMutableArray *waterSendings;
@property (nonatomic, strong) NSMutableArray *mDateArrayM; // 模型数组
@property (nonatomic, strong) EHNetwork *mNetwork;
@property (nonatomic, strong) UIView *mHintView;
@end

@implementation TableViewController

//1.懒加载
-(NSMutableArray *)waterSendings
{
    if (_waterSendings == nil) {
//        _waterSendings = [WaterSending waterSendingsList];
        
////        _waterSendings = [NSMutableArray arrayWithCapacity:0];
//        for (int i = 0; i < 20; i ++) {
////            [_waterSendings addObject:[NSString stringWithFormat:@"%d", i]];
//        }
        _waterSendings = [NSMutableArray array];
    }
    
    return _waterSendings;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    
    
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // 网络加载数据
    [self loadMoreStatus];
    self.title = @"送水";
    self.tableView.rowHeight = 100;
    // 初始化网络请求
//    self.mNetwork = [[EHNetwork alloc] init];
//    [self.tableView addFooterWithTarget:self action:@selector(loadMoreStatus)];
    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc]initWithTitle:@"返回" style:UIBarButtonItemStylePlain target:self action:@selector(backClick)];
}
- (void)backClick
{
    [self dismissViewControllerAnimated:YES completion:nil];
}

#pragma mark ----- tableView的代理方法
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return self.waterSendings.count;
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    
    MSWaterSendingCell *cell = [MSWaterSendingCell cellWithTableView:tableView];
    NSLog(@"%@",self.waterSendings[0]);
    NSLog(@"%@",self.waterSendings[1]);
    cell.model = self.waterSendings[indexPath.row];
    return cell;
}

#pragma mark  ---  网络请求
- (void)loadMoreStatus
{
//    NSDictionary *responseObject1 = @{@"businessId":@"1",@"businessName":@"guangfayinhang",@"introduce": @"this is my best goods",@"name":@"laoshanpijiu",@"publishTime":@"1428491194000",@"unitPrice":@"5000",@"icon":@"img_01"};
//    NSDictionary *responseObject2 = @{@"businessId":@"2",@"businessName":@"testprrrrraaaa22",@"introduce": @"22this is my best goods",@"name":@"laoshanpijiu",@"publishTime":@"1428491194000",@"unitPrice":@"Y4000",@"icon":@"img_02"};
#warning 返回结果是二进制数据 --- 模拟
    
    
    // 封装参数
  NSMutableDictionary *postDic = [NSMutableDictionary dictionary];        // 请求的数据条数。
    postDic[@"productCatalogId"] = @(1);
    postDic[@"maxId"]= @(0);
    postDic[@"count"] = @(10);
    
//
    AFHTTPRequestOperationManager *manager = [AFHTTPRequestOperationManager manager];
 
    NSString *url = @"http://192.168.2.200:8090/water/waterinformations/1001/0/10";
   
    [manager GET:url parameters:nil success:^(AFHTTPRequestOperation *operation, id responseObject) {
        
        NSLog(@"请求结果%@", responseObject);
        NSDictionary *result = [responseObject objectForKey:@"responseHeader"];
               NSLog(@"result %@   errorcode %@,   message %@",result,[result objectForKey:@"errorCode"],[result objectForKey:@"message"]);
        if ([[result objectForKey:@"errorCode"] isEqualToString:@"0000"]) {
            NSLog(@"查询成功并返回");
            
            NSArray *resultArr = [result objectForKey:@"responseBody"];
            
            for (NSDictionary *dict in resultArr) {
                WaterSending *ws = [[WaterSending alloc]init];
               //  ws.businessId = [dict[@"businessId"] integerValue];
               // ws.businessName = dict[@"businessName"];
                 ws.introduce = dict[@"introduce"];
                
                ws.preferPrice = dict[@"preferPrice"];
               
                ws.salePrice = dict[@"salePrice"];
               
                ws.unitPrice = dict[@"unitPrice"];
               
               
                [self.waterSendings addObject:ws];
            }
            
        }else{
            NSLog(@"失败");
            return ;
        }
        
        
       
        [MBProgressHUD hideHUD];
        
        // 关闭刷新提示
        [self.tableView footerEndRefreshing];
        
        // 模拟有数据 加载到 20
        for (int i = 0; i < 20; i ++) {
            [self.waterSendings addObject:[NSString stringWithFormat:@"%d", i]];
        }
        
        [self.tableView reloadData];
        
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {

        NSLog(@"失败结果: %@", error);
        
        [self.tableView footerEndRefreshing];
        
        [MBProgressHUD showError:@"请求失败"];

}];

}


//- (WaterSending *)orResponseObject:(NSDictionary *)responseObject arr:(NSArray *)arr
//{
////    NSMutableDictionary *dict = [NSMutableDictionary dictionary];
//    WaterSending *wsModel =[[WaterSending alloc]init];
//    NSLog(@"%@",arr[0]);
//    // 图片名称
//    if ([responseObject objectForKey:arr[0]]) {
//           wsModel.icon = [responseObject objectForKey:arr[0]];
//        
//    }
//    
//    // 商品名称
//    if ([responseObject objectForKey:arr[1]]) {
//
//        wsModel.businessName = [responseObject objectForKey:arr[1]];
//
//    }
//
//    if ([responseObject objectForKey:arr[2]]) {
//
//        wsModel.introduce = [responseObject objectForKey:arr[2]];
//
//    }
//
//    if ([responseObject objectForKey:arr[3]]) {
//
//        wsModel.unitPrice = [responseObject objectForKey:arr[3]];
//
//    }
//    return wsModel;
//}



// 点击某一行，进入产品详细页
- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    NewPruVcViewController *nv = [[NewPruVcViewController alloc]init];
    nv.waterSending = self.waterSendings[indexPath.row];
    [self.navigationController pushViewController:nv animated:YES];
}

@end
