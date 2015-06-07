//
//  RegisterViewController.m
//  民生小区
//
//  Created by 闫青青 on 15/4/23.
//  Copyright (c) 2015年 闫青青. All rights reserved.
//

#import "RegisterViewController.h"
#import "LoginViewController.h"
#import "RegistModel.h"
#import "AFNHelp.h"
@interface RegisterViewController ()

@end

@implementation RegisterViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    //背景色
     self.view.backgroundColor = [UIColor colorWithRed:0.234 green:0.234 blue:0.234 alpha:0.1];
    //红色界面
    UIImageView *imageView1 = [[UIImageView alloc]initWithFrame:CGRectMake(0, 0, self.view.bounds.size.width, 65)];
    NSString *imageName = [NSString stringWithFormat:@"register-head.png"];
    imageView1.image = [UIImage imageNamed:imageName];
    [self.view addSubview:imageView1];
    //返回按钮
    UIButton *backButton = [[UIButton alloc]initWithFrame:CGRectMake(20, 35, 25, 25)];
    [backButton setBackgroundImage:[UIImage imageNamed:@"login-2.png"] forState:UIControlStateNormal];
    [backButton addTarget:self action:@selector(buttonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:backButton];
    //完成按钮
    UIButton *commitButton = [[UIButton alloc]initWithFrame:CGRectMake(250, 35, 45, 25)];
    [commitButton setBackgroundImage:[UIImage imageNamed:@"register-2.png"] forState:UIControlStateNormal];
    [commitButton addTarget:self action:@selector(commitButtonClicked:) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:commitButton];
    //白色的头像
    UIImageView *iconBackImage = [[UIImageView alloc]initWithFrame:CGRectMake(self.view.bounds.size.width/2-50, 80, 90, 90)];
    NSString *iconBackImageName = [NSString stringWithFormat:@"register-3.png"];
    iconBackImage.image = [UIImage imageNamed:iconBackImageName];
    [self.view addSubview:iconBackImage];
    //上传头像按钮
    UIButton *upButton = [[UIButton alloc]initWithFrame:CGRectMake(230, 150, 70, 25)];
    [upButton setBackgroundImage:[UIImage imageNamed:@"register-4.png"] forState:UIControlStateNormal];
    [self.view addSubview:upButton];
    
    //下面的输入框和label
    NSArray *array = @[@"   用 户 名",@"   真实姓名",@"   性  别",@"   手 机 号",@"   验 证 码",@"   密  码",@"   确认密码",@"   详细地址"];
    for(int i = 0;i <8;i++){
        //label
        UILabel *label = [[UILabel alloc]initWithFrame:CGRectMake(0, 180+45*i, 90, 40)];
        label.text = array[i];
        label.font = [UIFont fontWithName:nil size:15];
        label.textColor = [UIColor colorWithRed:0.500 green:0.500 blue:0.500 alpha:0.9];
        label.backgroundColor = [UIColor whiteColor];
       
        //text
//        UITextField *userTextField = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*i, self.view.bounds.size.width-30, 40)];
//        textField.backgroundColor = [UIColor whiteColor];
//        textField.tag = i;
//        textField.layer.cornerRadius = 8;
        //传值
//        RegistModel *regist = [[RegistModel alloc]init];
        
        [self.view addSubview:label];
//        [self.view addSubview:textField];
    }
    RegistModel *regist = [[RegistModel alloc]init];
    
    //usertext
    UITextField *userTextField = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*0, self.view.bounds.size.width-30, 40)];
    userTextField.backgroundColor = [UIColor whiteColor];
    userTextField.text = regist.userName;
//    userTextField.layer.cornerRadius = 8;
    [self.view addSubview:userTextField];
    //realNameText
    UITextField *realNameText = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*1, self.view.bounds.size.width-30, 40)];
    realNameText.backgroundColor = [UIColor whiteColor];
    realNameText.text = regist.realName;
//    realNameText.layer.cornerRadius = 8;
    [self.view addSubview:realNameText];
    //sexText
    UITextField *sexText = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*2, self.view.bounds.size.width-30, 40)];
    sexText.backgroundColor = [UIColor whiteColor];
    sexText.text = regist.sex;
//    sexText.layer.cornerRadius = 8;
    [self.view addSubview:sexText];
    //phoneText
    UITextField *phoneText = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*3, self.view.bounds.size.width-30, 40)];
    phoneText.backgroundColor = [UIColor whiteColor];
    phoneText.text = regist.phoneNum;
//    phoneText.layer.cornerRadius = 8;
    [self.view addSubview:phoneText];
    //validateCodeText
    UITextField *validateText = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*4, self.view.bounds.size.width-30, 40)];
    validateText.backgroundColor = [UIColor whiteColor];
    validateText.text = regist.yanZhengCode;
//    validateText.layer.cornerRadius = 8;
    [self.view addSubview:validateText];
    //code
    UITextField *codeText = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*5, self.view.bounds.size.width-30, 40)];
    codeText.backgroundColor = [UIColor whiteColor];
    codeText.text = regist.passWord;
//    codeText.layer.cornerRadius = 8;
    [self.view addSubview:codeText];
    //commitCode
    UITextField *commitCodeText = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*6, self.view.bounds.size.width-30, 40)];
    commitCodeText.backgroundColor = [UIColor whiteColor];
    commitCodeText.text = regist.commitCode;
//    commitCodeText.layer.cornerRadius = 8;
    [self.view addSubview:commitCodeText];
    //address
    UITextField *addressText = [[UITextField alloc]initWithFrame:CGRectMake(90, 180+45*7, self.view.bounds.size.width-30, 40)];
    addressText.backgroundColor = [UIColor whiteColor];
//    addressText.layer.cornerRadius = 8;
    addressText.text = regist.address;
    [self.view addSubview:addressText];
    
}
//返回button点击事件
- (void)buttonClicked:(UIButton *)sender{
    //    ViewController *VC = [[ViewController alloc]init];
    LoginViewController *loginVC = [[LoginViewController alloc]init];
    [self presentViewController:loginVC animated:NO completion:^{
        
    }];
}
//完成按钮点击事件
- (void)commitButtonClicked:(UIButton *)sender{
    [AFNHelp inputValidateCodeWithBlock:^(NSDictionary *infoDic, NSError *error) {
        NSLog(@"%@",infoDic);
        
                NSArray *array = infoDic[@"info"];
        
               NSDictionary *dic = array[0];
       
                NSString *message = dic[@"message"];
        
               NSString *status = dic[@"status"];
        
                if ([status intValue] == 1) {
        
               UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"提示" message:message delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
      
                   [alertView show];
        
                   [self dismissViewControllerAnimated:YES completion:nil];
                }

        
    } and:nil];
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
