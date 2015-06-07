//
//  WaterSending.m
//  民生小区
//
//  Created by L on 15/4/13.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import "WaterSending.h"

@implementation WaterSending


- (instancetype)initWithDic:(NSDictionary *)dic
{
    if (self = [super init]) {
        [self setValuesForKeysWithDictionary:dic];
    }
    return self;
}

+ (instancetype)WaterSendingWithDic:(NSDictionary *)dic
{
    return [[self alloc] initWithDic:dic];
}

+(NSMutableArray *)waterSendingsList
{
    //plist的路径
    NSString *path = [[NSBundle mainBundle]pathForResource:@"" ofType:@"plist"];
    NSArray *dicArray = [NSArray arrayWithContentsOfFile:path];
    NSMutableArray *tmpArray = [NSMutableArray array];
    
    //字典转模型
    for (NSDictionary *dic in dicArray) {
        WaterSending *waterSending = [WaterSending waterSendingWithDic:dic];
        [tmpArray addObject:waterSending];
    }
    
    return tmpArray;
}
@end
