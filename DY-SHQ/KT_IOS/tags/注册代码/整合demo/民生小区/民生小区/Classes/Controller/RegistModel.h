//
//  RegistModel.h
//  民生小区
//
//  Created by 闫青青 on 15/4/24.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface RegistModel : NSObject
//用户名
@property (nonatomic, copy)NSString *userName;
//真实姓名
@property (nonatomic, copy)NSString *realName;
//性别
@property (nonatomic, assign)NSString * sex;
//手机号
@property (nonatomic, assign)NSString * phoneNum;
//验证码
@property (nonatomic, copy)NSString *yanZhengCode;
//密码
@property (nonatomic ,copy)NSString *passWord;
//确认密码
@property (nonatomic ,copy)NSString* commitCode;
//详细地址
@property (nonatomic, copy)NSString *address;


- (instancetype)initWithDic:(NSDictionary *)dic;
+ (id)registWithDic:(NSDictionary *)dic;

@end
