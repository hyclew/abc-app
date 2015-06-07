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
#import "MJExtension.h"

@interface MSWaterSendingCell ()

@property (weak, nonatomic) IBOutlet UIImageView *mIconImageView;
@property (weak, nonatomic) IBOutlet UILabel *introduce;

@property (weak, nonatomic) IBOutlet UILabel *unitPrice;

@property (weak, nonatomic) IBOutlet UILabel *preferPrice;
@property (weak, nonatomic) IBOutlet UILabel *salePrice;

- (IBAction)goBuy:(UIButton *)sender;


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
//    UIImageView *iconView = [[UIImageView alloc]init];
//    self.mIconImageView = iconView ;
//    iconView.frame = CGRectMake(10, 10, 80, 80);
//    [self.contentView addSubview:iconView];
    
//    UILabel *name = [[UILabel alloc]init];
//    name.frame = CGRectMake(100, 10, 200, 20);
//    name.backgroundColor = [UIColor redColor];
//    self.name = name;
//    [self.contentView addSubview:name];
    
    
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
    
    
    self.unitPrice.text = model.unitPrice;
    //简介
    self.introduce.text = model.introduce;
    // 银行卡价格
    self.preferPrice.text  = [NSString stringWithFormat:@"￥%@",model.preferPrice];
    //销售状态
    self.salePrice.text = [NSString stringWithFormat:@"￥%@",model.salePrice];
    //图片
   // [self.mIconImageView sd_setImageWithURL:[NSURL URLWithString:model.productUrl]placeholderImage:[UIImage imageName:@""]];

    
    // sdwebIMge
  //self.mIconImageView.image = [UIImage imageNamed:model.productUrl];
    // if(model.productUrl == nil)return;
    if(model.productUrl != nil || ![model.productUrl isEqualToString:@""]) {
    [self.mIconImageView sd_setImageWithURL:[NSURL URLWithString:model.productUrl] placeholderImage:[UIImage imageNamed:@"s"] options:SDWebImageRetryFailed |SDWebImageLowPriority];
}
    //self.name.text = [NSString stringWithFormat:@"商品名称:%@",model.businessName];
    
    
    
}
//    NSURL *url = [NSURL URLWithString:model.productUrl];
//
//    NSString *str = [model.productUrl stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding];
//
   // NSURL *url = [NSURL URLWithString:str];
   //    NSLog(@"url   %@",model.productUrl);
//   [self.mIconImageView sd_setImageWithURL:url placeholderImage:[UIImage imageNamed:@"占位图片"] options:SDWebImageRetryFailed |SDWebImageLowPriority];

//





- (IBAction)goBuy:(UIButton *)sender {
    
    }
@end
