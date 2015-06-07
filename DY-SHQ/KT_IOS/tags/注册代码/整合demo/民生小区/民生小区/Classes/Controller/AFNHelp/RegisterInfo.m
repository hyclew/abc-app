//
//  RegisterInfo.m
//  机械网登陆注册
//
//  Created by qianfeng on 15-1-28.
//  Copyright (c) 2015年 黎跃春. All rights reserved.
//

#import "RegisterInfo.h"

@implementation RegisterInfo


- (void)setValue:(id)value forUndefinedKey:(NSString *)key{

}

- (id)valueForUndefinedKey:(NSString *)key{

    return nil;
}


- (instancetype)initWithDic:(NSDictionary *)info{

    if (self = [super init]) {
        
        [self setValuesForKeysWithDictionary:info];
    }
    return self;
}

@end
