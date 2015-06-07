//
//  NewPruVcViewController.m
//  民生小区
//
//  Created by hanvon on 15/4/17.
//  Copyright (c) 2015年 itcast. All rights reserved.
//
#define kScreenWidth [UIScreen mainScreen].bounds.size.width
#define kScreenHeight [UIScreen mainScreen].bounds.size.height
#import "NewPruVcViewController.h"
#import "UIImageView+WebCache.h"
#import "WaterSending.h"
@interface NewPruVcViewController ()

@property (nonatomic, assign)NSInteger currentNum;

@property (nonatomic,assign)int PruId;

@end

@implementation NewPruVcViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    [ self setupView];
    self.view.backgroundColor = [UIColor whiteColor];
}

- (void)setupView
{
 
    UIImageView *imgV = [[UIImageView alloc]init];
    imgV.frame = CGRectMake(10, 64,kScreenWidth , 300);
    NSURL *url = [NSURL URLWithString:self.waterSending.productUrl];
    [imgV sd_setImageWithURL:url placeholderImage:[UIImage imageNamed:@"占位图片"] options:SDWebImageRetryFailed |SDWebImageLowPriority];
   
    [self.view addSubview:imgV];
    
    UILabel *pruName = [[UILabel alloc]init];
    pruName.frame = CGRectMake(10, 374, kScreenWidth, 50);
    pruName.text = [NSString stringWithFormat:@"商品名称 ：%@",self.waterSending.businessName];
    [self.view addSubview:pruName];
    
    UILabel *pruIntroduction = [[UILabel alloc] init];
    pruIntroduction.frame = CGRectMake(10, 230, kScreenWidth, 80);
    pruIntroduction.text  = [NSString stringWithFormat:@"商品简介 : %@", self.introduce];
    [self.view addSubview:pruIntroduction];
    
    UILabel *warmPrompt = [[UILabel alloc] init];
    warmPrompt.frame = CGRectMake(10, 300, kScreenWidth, 80);
    warmPrompt.text = [NSString stringWithFormat:@"温馨提示: %@", self.warmPrompt];
    [self.view addSubview:warmPrompt];
    self.warmPrompt = warmPrompt;
    
    CGRect frame = CGRectMake(15, 450, 130, 50);
    UIButton *addCart = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    addCart.backgroundColor = [UIColor redColor];
    [addCart setTitle:@"加入购物车" forState:UIControlStateNormal];
    addCart.frame = frame;
    [addCart addTarget:self action:@selector(addButtonClicked)forControlEvents: UIControlEventTouchUpInside];
    [addCart setBackgroundImage:[UIImage imageNamed:@""] forState:UIControlStateNormal];
    [self.view addSubview:addCart];
    self.addBtn = addCart;
    
    
    
    UIButton *hurryBuy = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    hurryBuy.backgroundColor = [UIColor redColor];
    [hurryBuy setTitle:@"立即购买" forState:UIControlStateNormal];
    hurryBuy.frame = CGRectMake(175, 450, 130, 50);
    [hurryBuy addTarget:self action:@selector(buyButtonClicked)forControlEvents:UIControlEventTouchUpInside];
    [hurryBuy setBackgroundImage:[UIImage imageNamed:@""] forState:UIControlStateNormal];
    [self.view addSubview:hurryBuy];
    
    
    UILabel *unitPrice = [[UILabel alloc] init];
    unitPrice.frame = CGRectMake(10, 350, kScreenWidth, 80);
    unitPrice.text = [NSString stringWithFormat:@" 价格:￥%@", self.unitPrice];
    [self.view addSubview:unitPrice];
    
    UILabel *numberLabel = [[UILabel alloc] init];
    numberLabel.frame = CGRectMake(150, 350, kScreenWidth, 80);
    numberLabel.text = @"数量:";
    [self.view addSubview:numberLabel];
    
    UIButton *minusBtn = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    minusBtn = [[UIButton alloc] initWithFrame:CGRectMake(195,350, 35, 80)];
    [minusBtn setImage:[UIImage imageNamed:@"buy_btn_left"] forState:UIControlStateNormal];
    [minusBtn setImage:[UIImage imageNamed:@"buy_btn_left"] forState:UIControlStateHighlighted];
    [minusBtn setImage:[UIImage imageNamed:@"buy_btn_left"] forState:UIControlStateSelected];
    [minusBtn addTarget:self action:@selector(minusMethod) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:minusBtn];
    self.minusBtn = minusBtn;
    
    UILabel *numLabel = [[UILabel alloc]init];
    numLabel = [[UILabel alloc] initWithFrame:CGRectMake(230, 350, 35, 80)];
    numLabel.backgroundColor = [UIColor clearColor];
    numLabel.text = [NSString stringWithFormat:@"%d",currentNum];
    
    [self.view addSubview:numLabel];
    
    
    UIButton *addBtn = [[UIButton alloc] init];
    addBtn = [[UIButton alloc] initWithFrame:CGRectMake(240, 350, 35, 80)];
    [addBtn setImage:[UIImage imageNamed:@"buy_btn_right"] forState:UIControlStateNormal];
    [addBtn setImage:[UIImage imageNamed:@"buy_btn_right"] forState:UIControlStateHighlighted];
    [addBtn setImage:[UIImage imageNamed:@"buy_btn_right"] forState:UIControlStateSelected];
    [addBtn addTarget:self action:@selector(addMethod) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:addBtn];
    
    
}


//  加入购物车点击事件
- (void) addButtonClicked
{
    
}
//  立即购买点击事件
- (void) buyButtonClicked
{
    
}
static int currentNum = 1;
-(void) minusMethod
{
    NSLog(@"***minus***");
    if ( _currentNum > 0) {
        _currentNum--;
        _numLabel.text = [NSString stringWithFormat:@"%d",currentNum];
    }
}
-(void) addMethod
{
    _currentNum++;
    NSLog(@"***add*** %d",currentNum);
    _numLabel.text = [NSString stringWithFormat:@"%d",currentNum];
}

//    UILabel *unitPrice = [[UILabel alloc] init];
//    unitPrice.frame = CGRectMake(10, 300, kScreenWidth, 50);
//    unitPrice.text = [NSString stringWithFormat:@"价格: %@", self.WaterSending.unitPrice];
//    [self.view addSubview:unitPrice];




#pragma mark 后面就是写控件了。。。



- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
