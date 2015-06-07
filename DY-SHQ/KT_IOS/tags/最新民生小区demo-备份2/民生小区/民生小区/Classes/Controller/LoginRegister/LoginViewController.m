//
//  LoginViewController.m
//  民生小区
//
//  Created by 闫青青 on 15/4/23.
//  Copyright (c) 2015年 闫青青. All rights reserved.
//

#import "LoginViewController.h"
#import "ViewController.h"
#import "RegisterViewController.h"
@interface LoginViewController ()

@end

@implementation LoginViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    //红色界面
    UIImageView *imageView1 = [[UIImageView alloc]initWithFrame:CGRectMake(0, 0, self.view.bounds.size.width, 65)];
    NSString *imageName = [NSString stringWithFormat:@"生活圈.jpg"];
    imageView1.image = [UIImage imageNamed:imageName];
    [self.view addSubview:imageView1];
    //返回按钮
    UIButton *backButton = [[UIButton alloc]initWithFrame:CGRectMake(20, 35, 25, 25)];
    [backButton setBackgroundImage:[UIImage imageNamed:@"login-2.png"] forState:UIControlStateNormal];
    [backButton addTarget:self action:@selector(buttonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:backButton];
    //注册按钮
    UIButton *registButton = [[UIButton alloc]initWithFrame:CGRectMake(250, 35, 50, 25)];
    [registButton setBackgroundImage:[UIImage imageNamed:@"login-4.png"] forState:UIControlStateNormal];
    [registButton addTarget:self action:@selector(registButtonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:registButton];
    //输入框
    UITextField *textField = [[UITextField alloc] initWithFrame:CGRectMake(60, 100, 200, 50)];
    //[textField];
}
//登录button点击事件
- (void)buttonClicked:(UIButton *)sender{
//    ViewController *VC = [[ViewController alloc]init];
    [self dismissViewControllerAnimated:NO completion:^{
       
    }];
}
//注册button点击事件
- (void)registButtonClicked:(UIButton *)sender{
    //    ViewController *VC = [[ViewController alloc]init];
    RegisterViewController *registVC = [[RegisterViewController alloc]init];
    [self presentViewController:registVC animated:NO completion:nil];
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
