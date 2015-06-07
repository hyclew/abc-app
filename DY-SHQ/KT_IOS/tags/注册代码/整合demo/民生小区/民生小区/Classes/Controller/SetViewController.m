//
//  SetViewController.m
//  民生小区
//
//  Created by 闫青青 on 15/4/24.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import "SetViewController.h"
#import "Util/Header.h"
#import "SetCell.h"
#import "LoginViewController.h"


@interface SetViewController ()<UITableViewDataSource,UITableViewDelegate>
@property (nonatomic, retain) UITableView *tableView;
@property (nonatomic, copy) NSArray *textArray;
@property (nonatomic, copy) NSArray *imageNameArray;

@end

@implementation SetViewController
@synthesize tableView = _tableView;
@synthesize textArray = _textArray;
@synthesize imageNameArray = _imageNameArray;
- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    self.textArray = @[@"购物车",@"全部订单",@"我的钱包",@"退款单",@"我的消息",@"我要开店",@"一键分享",@"系统设置"];
    self.imageNameArray = @[@"a5.png",@"a6.png",@"a7.png",@"a8.png",@"a9.png",@"a10.png",@"a11.png",@"a12.png"];
    
    
    //滑不到头时改变这个属性
    self.automaticallyAdjustsScrollViewInsets = YES;
#pragma mark--tableView
    _tableView = [[UITableView alloc]initWithFrame:CGRectMake(0,NAVIGATIONBAR_HEIGHT+85 , SCREEN_WIDTH, SCREEN_HEIGHT-NAVIGATION_ADD_STATUS_HEIGHT) style:UITableViewStyleGrouped];
    self.tableView.dataSource =self;
    self.tableView.delegate = self;
    UINib *nib = [UINib nibWithNibName:@"SetCell" bundle:nil];
    [self.tableView registerNib:nib forCellReuseIdentifier:@"SetCell"];
    //设置每个section之间的间隙
    self.tableView.sectionHeaderHeight = 1;
    [self.view addSubview:self.tableView];
    
    
    //背景色
    //     [self.view setBackgroundColor:[UIColor colorWithRed:0.242 green:0.242 blue:0.243 alpha:0.1]];
    
    //红色界面
    UIImageView *imageView = [[UIImageView alloc]initWithFrame:CGRectMake(0, 0, self.view.bounds.size.width, 65)];
    NSString *imageName = [NSString stringWithFormat:@"生活圈.jpg"];
    imageView.image = [UIImage imageNamed:imageName];
    [self.view addSubview:imageView];
    
    //头像设置
    UIButton *iconButton = [[UIButton alloc] initWithFrame:CGRectMake(self.view.bounds.size.width/2-45, 70, 90, 90)];
    [iconButton setBackgroundImage:[UIImage imageNamed:@"a2.png"] forState:UIControlStateNormal];
    iconButton.layer.cornerRadius = 8;
    iconButton.layer.masksToBounds = YES;
    
    //头像后面的白色背景
    UIImageView *iconBackImage = [[UIImageView alloc]initWithFrame:CGRectMake(0, 65, self.view.bounds.size.width, 95)];
    NSString *iconBackImageName = [NSString stringWithFormat:@"640-90.png"];
    iconBackImage.image = [UIImage imageNamed:iconBackImageName];
    [self.view addSubview:iconBackImage];
    [self.view addSubview:iconButton];
    
    //登录button
    UIButton *loginButton = [[UIButton alloc]initWithFrame:CGRectMake(23, 120, 70, 30)];
    [loginButton setBackgroundImage:[UIImage imageNamed:@"a3.png"] forState:UIControlStateNormal];
    //    loginButton.backgroundColor = [UIColor cyanColor];
    //    [loginButton setTitle:@"登录" forState:UIControlStateNormal];
    //    [loginButton setTitleColor: [UIColor purpleColor]  forState:UIControlStateNormal];
    //    [loginButton setTitleColor:[UIColor colorWithRed:0.410 green:1.000 blue:0.378 alpha:1.000]forState:UIControlStateSelected];
    
    //    loginButton.titleLabel.font = [UIFont italicSystemFontOfSize:14];
    [loginButton addTarget:self action:@selector(buttonClicked:) forControlEvents:UIControlEventTouchUpInside];
    
    //注册button
    UIButton *registButton = [[UIButton alloc]initWithFrame:CGRectMake(self.view.bounds.size.width-90, 120, 70, 30)];
    [registButton setBackgroundImage:[UIImage imageNamed:@"a4.png"] forState:UIControlStateNormal];
    //    registButton.backgroundColor = [UIColor cyanColor];
    //    [registButton setTitle:@"注册" forState:UIControlStateNormal];
    //    [registButton setTitleColor:[UIColor purpleColor]  forState:UIControlStateNormal];
    //    [registButton setTitleColor:[UIColor colorWithRed:0.410 green:1.000 blue:0.378 alpha:1.000]forState:UIControlStateSelected];
    //    registButton.titleLabel.font = [UIFont italicSystemFontOfSize:14];
    //    [registButton addTarget:self action:@selector(click:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:loginButton];
    [self.view addSubview:registButton];
}
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    if(section == 0){
        return 3;
    }
    else if(section == 1){
        return 1;
    }
    else
        return 3;
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    SetCell *setCell = [tableView dequeueReusableCellWithIdentifier:@"SetCell"];
    if(indexPath.section == 0){
        setCell.iconImageView.image = [UIImage imageNamed:self.imageNameArray[indexPath.row + 0]];
        setCell.nameLabel.text = self.textArray[indexPath.row + 0];
    }
    else if(indexPath.section == 1){
        setCell.iconImageView.image = [UIImage imageNamed:self.imageNameArray[indexPath.row + 3]];
        setCell.nameLabel.text = self.textArray[indexPath.row + 3];
    }
    else if(indexPath.section == 2){
        setCell.iconImageView.image = [UIImage imageNamed:self.imageNameArray[indexPath.row + 4]];
        setCell.nameLabel.text = self.textArray[indexPath.row + 4];
    }
    
    return setCell;
    
}
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 3;
}
// 返回cell高度
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    return self.view.bounds.size.width/(64/10);
}
//设置页头高度
- (CGFloat)tableView:(UITableView *)tableView heightForHeaderInSection:(NSInteger)section{
    return 0;
}
//设置页脚高度，也就是cell之间的间隙
- (CGFloat)tableView:(UITableView *)tableView heightForFooterInSection:(NSInteger)section{
    return 2;
}
//登录button点击事件
- (void)buttonClicked:(UIButton *)sender{
    LoginViewController *loginVC = [[LoginViewController alloc]init];
    [self presentViewController:loginVC animated:NO completion:nil];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
