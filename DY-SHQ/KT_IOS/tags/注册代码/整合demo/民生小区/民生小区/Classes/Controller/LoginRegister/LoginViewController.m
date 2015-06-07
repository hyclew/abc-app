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
#import "SetViewController.h"
#import "ForgetViewController.h"
@interface LoginViewController ()

@end

@implementation LoginViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    //红色界面
    UIImageView *imageView1 = [[UIImageView alloc]initWithFrame:CGRectMake(0, 0, self.view.bounds.size.width, 65)];
    NSString *imageName = [NSString stringWithFormat:@"login-head.png"];
    imageView1.image = [UIImage imageNamed:imageName];
    [self.view addSubview:imageView1];
    //返回按钮
    UIButton *backButton = [[UIButton alloc]initWithFrame:CGRectMake(20, 35, 25, 25)];
    [backButton setBackgroundImage:[UIImage imageNamed:@"login-2.png"] forState:UIControlStateNormal];
    [backButton addTarget:self action:@selector(buttonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:backButton];
    //注册按钮
    UIButton *registButton = [[UIButton alloc]initWithFrame:CGRectMake(250, 35, 45, 25)];
    [registButton setBackgroundImage:[UIImage imageNamed:@"login-4.png"] forState:UIControlStateNormal];
    [registButton addTarget:self action:@selector(registButtonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:registButton];
    //设置背景色
    self.view.backgroundColor = [UIColor colorWithRed:0.234 green:0.234 blue:0.234 alpha:0.1];
    //手机号输入框
    UITextField *textField = [[UITextField alloc] initWithFrame:CGRectMake(10, 100, 300, 50)];
    textField.backgroundColor = [UIColor whiteColor];
    textField.layer.cornerRadius = 8;
    textField.layer.masksToBounds = YES;
    textField.placeholder = @"   手机号";
    //密码输入框
    UITextField *passwText = [[UITextField alloc]initWithFrame:CGRectMake(10, 155, 300, 50)];
    passwText.backgroundColor = [UIColor whiteColor];
    passwText.layer.cornerRadius = 8;
    passwText.layer.masksToBounds = YES;
    passwText.placeholder = @"   密码";
    [self.view addSubview:textField];
    [self.view addSubview:passwText];
    //登录界面的登录按钮
    UIButton *loginButton = [[UIButton alloc]initWithFrame:CGRectMake(15, 260, 290, 45)];
    [loginButton setBackgroundImage:[UIImage imageNamed:@"login-1.png"] forState:UIControlStateNormal];
    //    [loginButton addTarget:self action:@selector(loginButtonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:loginButton];
    //忘记密码button
    UIButton *forgetButton = [[UIButton alloc]initWithFrame:CGRectMake(240, 240, 60, 15)];
    [forgetButton setBackgroundImage:[UIImage imageNamed:@"login-0.png"] forState:UIControlStateNormal];
    [forgetButton addTarget:self action:@selector(forgetButtonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:forgetButton];
    

}
//返回button点击事件
- (void)buttonClicked:(UIButton *)sender{
    //    ViewController *VC = [[ViewController alloc]init];
    SetViewController *setVC = [[SetViewController alloc]init];
    [self presentViewController:setVC animated:NO completion:nil];
}
//注册button点击事件
- (void)registButtonClicked:(UIButton *)sender{
    //    ViewController *VC = [[ViewController alloc]init];
    RegisterViewController *registVC = [[RegisterViewController alloc]init];
    [self presentViewController:registVC animated:NO completion:nil];
}
//忘记密码button点击事件
- (void)forgetButtonClicked:(UIButton *)sender{
    ForgetViewController *forgetVC = [[ForgetViewController alloc]init];
    [self presentViewController:forgetVC animated:NO completion:nil];
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
