//
//  AFNHelp.m
//  机械网登陆注册
//
//  Created by qianfeng on 15-1-28.
//  Copyright (c) 2015年 黎跃春. All rights reserved.
//

#import "AFNHelp.h"
#import "AFAppDotNetAPIClient.h"
#import "RegistModel.h"
//#import "RegisterInfo.h"

//凡是碰到用户名，密码，电话号码，用户id时需要往服务器传数据时需要加密，如果从服务器取到的数据里面有用户名，密码，电话号码，用户id，需要解密


@implementation AFNHelp

#pragma mark --获取验证码
/*
 接口基本URL：
 http://api.d1cm.com/appaccount/register.action
 一个完整的url请求例子：
 http://api.d1cm.com/appaccount/register.action?mobile=?&pwd=?&username=?
 
 
 验证码：
 http://aps.etalkim.com/etalk/api/mobile/existMobileAndSendCode?mobilenum=手机号
 */
+ (NSURLSessionDataTask *)getValidateCodeWithBlock:(void (^)(RegistModel *info, NSError *error))block and:(NSDictionary *)parameters{
    
    return [[AFAppDotNetAPIClient sharedClient] GET:@"etalk/api/mobile/existMobileAndSendCode?mobilenum=手机号" parameters:parameters success:^(NSURLSessionDataTask *task, NSDictionary *responseObject) {
        //return [[AFAppDotNetAPIClient sharedClient] GET:@"etalk/api/mobile/existMobileAndSendCode?mobilenum=手机号" parameters:parameters success:^(NSURLSessionDataTask *task, NSDictionary *responseObject)
        
        /*
         {
         info =     (
         {
         message = "\U6ce8\U518c\U5408\U6cd5\U6709\U6548";
         status = 1;
         tempuid = 1249;
         }
         );
         tabtile = "\U7528\U6237\U6ce8\U518c";
         }
         */
        
        
        NSArray *infos = responseObject[@"info"];
        NSDictionary *inDic = infos[0];
        
//        创建数据模型对象
//        RegisterInfo *info = [[RegisterInfo alloc] initWithDic:inDic];
        
//        18657141238
        
        if (block) {
//            block(info,nil);
        }
        
    } failure:^(NSURLSessionDataTask *task, NSError *error) {
        
        NSLog(@"%@",[error localizedDescription]);
        
        if (block) {
//            block([[RegisterInfo alloc] init],nil);
        }
    }];
}

#pragma mark --输入注册验证码
//接口基本URL：
//http://api.d1cm.com/appaccount/checkcode.action
//一个完整的url请求例子：
//http://api.d1cm.com/appaccount/checkcode.action?tempuid=?&code=?
+ (NSURLSessionDataTask *)inputValidateCodeWithBlock:(void (^)(NSDictionary *infoDic, NSError *error))block and:(NSDictionary *)parameters{
    
    
//    [[AFAppDotNetAPIClient sharedClient] POST:<#(NSString *)#> parameters:<#(id)#> constructingBodyWithBlock:<#^(id<AFMultipartFormData> formData)block#> success:<#^(NSURLSessionDataTask *task, id responseObject)success#> failure:<#^(NSURLSessionDataTask *task, NSError *error)failure#>];
    
    return [[AFAppDotNetAPIClient sharedClient] POST:@"user/register" parameters:parameters success:^(NSURLSessionDataTask *task, NSDictionary *responseObject) {
        NSDictionary *jsonDic = [responseObject objectForKey:@"JSON"];
        NSDictionary *userBaseDic = [responseObject objectForKey:@"userBase"];
        NSDictionary *userDetailedDIC = [responseObject objectForKey:@"userDetailed"];
        NSDictionary *loginUserDic = [responseObject objectForKey:@"loginUser"];
        [userBaseDic enumerateKeysAndObjectsUsingBlock:^(NSDictionary* key, id obj, BOOL *stop) {
            RegistModel *regist = [[RegistModel alloc]init];
            regist.realName = obj[@"name"];
            regist.address = obj[@"address"];
            regist.phoneNum = obj[@"phone"];
            
        }];
        [userDetailedDIC enumerateKeysAndObjectsUsingBlock:^(NSDictionary * key, id obj, BOOL *stop) {
            RegistModel *regist = [[RegistModel alloc]init];
            regist.sex = obj[@"sex"];
        }];
        [loginUserDic enumerateKeysAndObjectsUsingBlock:^(NSDictionary * key, id obj, BOOL *stop) {
            RegistModel *regist = [[RegistModel alloc]init];
            regist.userName = obj[@"username"];
            regist.passWord = obj[@"password"];
//            obj[@"username"]=regist.userName;
        }];
        [jsonDic setValue:userBaseDic forKey:@"userBase"];
        [jsonDic setValue:userDetailedDIC forKey:@"userDetailed"];
        [jsonDic setValue:loginUserDic forKey:@"loginUser"];
        NSLog(@"请求结果:%@",jsonDic);
        /*
         {
         info =     (
         {
         message = "\U6ce8\U518c\U5408\U6cd5\U6709\U6548";
         status = 1;
         tempuid = 1249;
         }
         );
         tabtile = "\U7528\U6237\U6ce8\U518c";
         }
         */
        
        
        
        
        //        18657141238
        
        if (block) {
            block(responseObject,nil);
        }
        
    } failure:^(NSURLSessionDataTask *task, NSError *error) {
        
        NSLog(@"%@",[error localizedDescription]);
        
        if (block) {
            block([NSDictionary dictionary],nil);
        }
    }];
}




@end
