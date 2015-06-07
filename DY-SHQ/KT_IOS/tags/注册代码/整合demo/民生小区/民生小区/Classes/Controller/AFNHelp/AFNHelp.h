//
//  AFNHelp.h
//  机械网登陆注册
//
//  Created by qianfeng on 15-1-28.
//  Copyright (c) 2015年 黎跃春. All rights reserved.
//

#import <Foundation/Foundation.h>
@class RegistModel;
@interface AFNHelp : NSObject

/*
 接口基本URL：
 http://api.d1cm.com/appaccount/register.action
 一个完整的url请求例子：
 http://api.d1cm.com/appaccount/register.action?mobile=?&pwd=?&username=?
 */
+ (NSURLSessionDataTask *)getValidateCodeWithBlock:(void (^)(RegistModel *info, NSError *error))block and:(NSDictionary *)parameters;


#pragma mark --输入注册验证码
//接口基本URL：
//http://api.d1cm.com/appaccount/checkcode.action
//一个完整的url请求例子：
//http://api.d1cm.com/appaccount/checkcode.action?tempuid=?&code=?
+ (NSURLSessionDataTask *)inputValidateCodeWithBlock:(void (^)(NSDictionary *infoDic, NSError *error))block and:(NSDictionary *)parameters;



@end








