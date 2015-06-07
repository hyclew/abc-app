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
@property (nonatomic, strong) UILabel *businessName;
@property (nonatomic, strong) UILabel *introduce;
@property (nonatomic, strong) UILabel *unitPrice;//商品单价
@property (nonatomic, strong) UILabel *prasie;
@property (nonatomic, strong) UILabel *warmPrompt;//温馨提示
@property (nonatomic, strong) UIButton *addCart;
@property (nonatomic, strong) UIButton *hurryBuy;
@property (nonatomic, strong) UILabel *numbers;//库存数量
@property (nonatomic, strong) UIButton *minusBtn;//加按钮
@property (nonatomic, strong) UIButton *addBtn;// 减按钮
@property (nonatomic, strong) UILabel *numLabel;
//@property (nonatomic, strong) UILabel *currentNum;

@property (nonatomic, copy) NSString *ID;
@property (nonatomic, strong) UILabel *evaluate;//评价
@end
