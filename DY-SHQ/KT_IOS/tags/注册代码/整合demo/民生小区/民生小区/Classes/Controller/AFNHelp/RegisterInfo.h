//
//  RegisterInfo.h
//  机械网登陆注册
//
//  Created by qianfeng on 15-1-28.
//  Copyright (c) 2015年 黎跃春. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface RegisterInfo : NSObject
//message
//status
//tempuid

// 提示是否注册合法有效
@property (nonatomic, copy) NSString *message;

//注册的状态，如果为1，注册成功，如果为0，失败
@property (nonatomic, copy) NSString *status;

//输入注册验证码时，需要带的参数
@property (nonatomic, copy) NSString *tempuid;

//初始化化方法
- (instancetype)initWithDic:(NSDictionary *)info;


@end
