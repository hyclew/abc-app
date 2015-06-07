//
//  MSWaterSendingCell.m
//  民生小区
//
//  Created by Milo. on 15-4-15.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import "MSWaterSendingCell.h"
#import "WaterSending.h"
#import "UIImageView+WebCache.h"

@interface MSWaterSendingCell ()
@property (weak, nonatomic)  UIImageView *mIconImageView;       // 图标
@property (weak, nonatomic)  UILabel *name;              // 商品名称
@property (weak, nonatomic)  UIImageView *mReputationImageView; // 信誉图片
@property (weak, nonatomic)  UILabel *introduce;           // 商品简介
@property (weak, nonatomic)  UILabel *unitPrice;  // 优惠价
@property (weak, nonatomic)  UILabel *mMarketPriceLabel;        // 市场价


@end

@implementation MSWaterSendingCell

- (void)awakeFromNib {
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

}

+ (instancetype)cellWithTableView:(UITableView *)tableView
{
    static NSString *ID = @"cell";
    MSWaterSendingCell *cell = [tableView dequeueReusableCellWithIdentifier:ID];
//    if (cell == nil)
//        cell = [[[NSBundle mainBundle] loadNibNamed:@"MSWaterSendingCell" owner:nil options:nil] lastObject];
    
    if (cell == nil) {
        cell = [[MSWaterSendingCell alloc]initWithStyle:UITableViewCellStyleDefault reuseIdentifier:ID];
    }
    return  cell;
}

- (instancetype)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier
{
    if (self = [super initWithStyle:style reuseIdentifier:reuseIdentifier])
    {
        [self setupView];
    }
    return self;
}

- (void)setupView
{
#pragma mark 位置自己调整
    UIImageView *iconView = [[UIImageView alloc]init];
    self.mIconImageView = iconView ;
    iconView.frame = CGRectMake(10, 10, 80, 80);
    [self.contentView addSubview:iconView];
    
    UILabel *name = [[UILabel alloc]init];
    name.frame = CGRectMake(100, 10, 200, 20);
    name.backgroundColor = [UIColor redColor];
    self.name = name;
    [self.contentView addSubview:name];
    
    
    UILabel *unitPrice = [[UILabel alloc]init];
    unitPrice.frame = CGRectMake(100, 40, 200, 20);
        unitPrice.backgroundColor = [UIColor greenColor];
    self.unitPrice = unitPrice;
    [self.contentView addSubview:unitPrice];
    
    
    UILabel *introduce = [[UILabel alloc]init];
    introduce.frame = CGRectMake(100, 70, 200, 20);
        introduce.backgroundColor = [UIColor orangeColor];
    self.introduce = introduce;
    [self.contentView addSubview:introduce];
}

// 设置模型数据

- (void)setModel:(WaterSending *)model
{
    _model = model;
    
    // sdwebIMge
//    self.mIconImageView.image = [UIImage imageNamed:model.productUrl];
   
    NSURL *url = [NSURL URLWithString:model.productUrl];
if(model.productUrl == nil)return;
    NSString *str = [model.productUrl stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding];
 //  NSURL *url = [NSURL URLWithString:str];
       NSLog(@"url   %@",model.productUrl);
   [self.mIconImageView sd_setImageWithURL:url placeholderImage:[UIImage imageNamed:@"占位图片"] options:SDWebImageRetryFailed |SDWebImageLowPriority];
    self.name.text = [NSString stringWithFormat:@"商品名称:%@",model.businessName];
//    self.mReputationImageView.image = [UIImage imageNamed:model.reputation];
    self.introduce.text = [NSString stringWithFormat:@"价格:%@",model.introduce];
    self.unitPrice.text = model.unitPrice;

}

@end
