//
//  NewPruVcViewController.h
//  民生小区
//
//  Created by hanvon on 15/4/17.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "WaterSending.h"
@interface NewPruVcViewController : UIViewController
@property (nonatomic,strong) WaterSending *waterSending;

@property (nonatomic, strong) UIView *icon;

@property (nonatomic, strong) UILabel *introduce;
@property (nonatomic, strong) UILabel *unitPrice;//商品单价
@property (nonatomic, strong) UILabel *preferPrice;
@property (nonatomic, strong) UILabel *salePrice;
@property (nonatomic, strong) UIButton *minusBtn;//加按钮
@property (nonatomic, strong) UIButton *addBtn;// 减按钮
@property (nonatomic, strong) UILabel *numLabel;
//@property (nonatomic, strong) UILabel *currentNum;

@property (nonatomic, copy) NSString *ID;
@property (nonatomic, strong) UILabel *evaluate;//评价
@end
