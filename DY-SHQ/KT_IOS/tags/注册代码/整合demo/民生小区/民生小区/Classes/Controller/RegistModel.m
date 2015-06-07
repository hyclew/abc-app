//
//  RegistModel.m
//  民生小区
//
//  Created by 闫青青 on 15/4/24.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import "RegistModel.h"

@implementation RegistModel
- (void)setValue:(id)value forUndefinedKey:(NSString *)key{
}

- (id)valueForUndefinedKey:(NSString *)key{
    
    return nil;
}
- (instancetype)initWithDic:(NSDictionary *)dic{
    if(self = [super init]){
        [self setValuesForKeysWithDictionary:dic];
    }
    return self;
    
}
+ (id)registWithDic:(NSDictionary *)dic{
    RegistModel *registModel = [[RegistModel alloc]initWithDic:dic];
    return registModel;
    
}

@end
