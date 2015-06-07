//
//  WaterSending.h
//  民生小区
//
//  Created by L on 15/4/13.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface WaterSending : NSObject
//@property (nonatomic, copy) NSString *icon;  // 图标
@property (nonatomic, copy) NSString *businessName ;   //商品名字
//@property (nonatomic, assign) NSInteger numbers;

@property (nonatomic, copy) NSString * introduce; //商品简介

@property (nonatomic, copy) NSString * unitPrice;    //商品单价

@property (nonatomic, strong)NSDate *publishTime; //发布时间
@property (nonatomic, copy) NSString *name;//商品名字

@property (nonatomic, assign)NSInteger businessId; //商家ID
@property (nonatomic, copy) NSString *productUrl;//产品图片路径
@property (nonatomic, copy) NSString *preferPrice;
@property (nonatomic, copy) NSString *salePrice;
        //
- (instancetype)initWithDic:(NSDictionary *)dic;
+ (instancetype)waterSendingWithDic:(NSDictionary *)dic;

+ (NSMutableArray *)waterSendingsList;
@end
