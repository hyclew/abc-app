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


@property (nonatomic,weak) UIScrollView *scrollView;
@property (nonatomic,strong) NSTimer *timer;
@property (nonatomic,weak) UIPageControl *pageControl;

@end

@implementation NewPruVcViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    [ self setupView];
    self.view.backgroundColor = [UIColor whiteColor];
    
    // 初始化图片轮播起
    [self initImgPlay];
}




//图片轮播起//
- (void)initImgPlay{
    
    UIScrollView *scV = [[UIScrollView alloc]init];
    scV.frame = CGRectMake(0, 80, 640, 360);
    scV.backgroundColor = [UIColor redColor];
    
    [self.view addSubview:scV];
    self.scrollView = scV;
    
    int count = 3;
    CGFloat imgW = 260;
    CGFloat imgH = 260;
    for (int i = 0; i < count; i++){
        UIImageView *imageView = [[UIImageView alloc] init];
        NSString *imgName = [NSString stringWithFormat:@"img_%02d", i+1];
        imageView.image = [UIImage imageNamed:imgName];
        //frame
        CGFloat imgY = 100;
        CGFloat imgX = i * imgW;
        imageView.frame = CGRectMake(imgX, 0, imgW, imgH);
        [self.scrollView addSubview:imageView];
        
    }
    
    // 设置返回按钮title
    //   UIBarButtonItem *item = [[UIBarButtonItem alloc] initWithTitle:@"首页" style:UIBarButtonItemStylePlain target:nil action:nil];
    
    
    
    //设置scrollView的滚动范围
    self.scrollView.contentSize = CGSizeMake(count * imgW, imgH*0.3);
    
    self.scrollView.showsHorizontalScrollIndicator = NO;
    
    //3.启用分业
    self.scrollView.pagingEnabled = YES;
    
    //设置分业控件
    self.pageControl.numberOfPages = count;
    
    //5.设置代理
    self.scrollView.delegate = self;
    
    //6.定时器
    [self startTimer];
    

    
    // 添加page
    UIPageControl *pageVC = [[UIPageControl alloc]init];
    pageVC.numberOfPages = count;
    //   pageVC.frame = CGRectMake(0, imgH *0.8, 10, 10);
//    pageVC.centerX = scV.width*0.5;
//    pageVC.centerY = 64 + scV.height *0.93;
    pageVC.currentPageIndicatorTintColor = [UIColor yellowColor];
    pageVC.pageIndicatorTintColor = [UIColor blueColor];
    [self.view addSubview:pageVC];
    self.pageControl = pageVC;
    
}
-(void)nextImage
{
    NSInteger page = self.pageControl.currentPage;
    if (page == self.pageControl.numberOfPages - 1){
        page = 0;
    }else{
        page++;
    }
    [self.scrollView setContentOffset:CGPointMake(page * self.scrollView.frame.size.width, 0)animated:YES];
    
}
#pragma mark - scrollView的代理方法
//正在滚动
-(void)scrollViewDidScroll:(UIScrollView *)scrollView
{
    //当前页面
    int page = (scrollView.contentOffset.x + 0.5 * scrollView.frame.size.width) / scrollView.frame.size.width;
    self.pageControl.currentPage = page;
    
}

//开始滚动
-(void)scrollViewWillBeginDragging:(UIScrollView *)scrollView;
{
    [self stopTimer];
}
//停止滚动
-(void)scrollViewDidEndDragging:(UIScrollView *)scrollView willDecelerate:(BOOL)decelerate
{
    [self startTimer];
}

/**
 *  开始定时器
 */
-(void)startTimer
{
    NSTimer *timer = [NSTimer timerWithTimeInterval:2.0 target:self selector:@selector(nextImage) userInfo:nil repeats:YES];
    
    NSRunLoop *loop = [NSRunLoop currentRunLoop];
    [loop addTimer:timer forMode:NSRunLoopCommonModes];
    self.timer = timer;
}
-(void)stopTimer;
{
    [self.timer invalidate];
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
    
//    UILabel *warmPrompt = [[UILabel alloc] init];
//    warmPrompt.frame = CGRectMake(10, 300, kScreenWidth, 80);
//    warmPrompt.text = [NSString stringWithFormat:@"温馨提示: %@", self.warmPrompt];
//    [self.view addSubview:warmPrompt];
//    self.warmPrompt = warmPrompt;
    
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
