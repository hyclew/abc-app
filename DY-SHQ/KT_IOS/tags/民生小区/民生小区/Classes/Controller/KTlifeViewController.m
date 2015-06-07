//
//  KTlifeViewController.m
//  民生小区
//
//  Created by 罗芳芳 on 15/4/23.
//  Copyright (c) 2015年 itcast. All rights reserved.
//

#import "KTlifeViewController.h"
#import "KTLifeSearchBar.h"
#import "KTTarBarController.h"
#import "UIView+Frame.h"
#import "ViewController.h"
#import "TableViewController.h"

#define kScreenWidth [UIScreen mainScreen].bounds.size.width
#define kScreenHight [UIScreen mainScreen].bounds.size.height
@interface KTlifeViewController ()<UITextFieldDelegate,UITableViewDelegate>
{
   

    
    
}
@property (nonatomic, strong)KTLifeSearchBar *searchBar;
@property (nonatomic,weak) UIScrollView *scrollView;
@property (nonatomic,weak) UITableView *ksTableView;
@property (nonatomic,strong) NSTimer *timer;
@property (nonatomic,weak) UIPageControl *pageControl;

@end

@implementation KTlifeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
   // 初始化图片轮播起
   [self initImgPlay];
   
   [self initTopView];
   
   // 产品
   CGFloat prScY = 64+kScreenHight*0.31;
   UIScrollView *scrollView =[[UIScrollView alloc]initWithFrame:CGRectMake(0,prScY , kScreenWidth,kScreenHight - prScY - 54)];
   scrollView.contentSize=CGSizeMake(kScreenWidth,kScreenHight);
   scrollView.backgroundColor = [UIColor colorWithRed:242/255.0 green:242/255.0 blue:242/255.0 alpha:1];
   scrollView.showsVerticalScrollIndicator = NO;
   [self.view addSubview:scrollView];
   
   [self initCommonTools];
   
   
    
}

- (BOOL)prefersStatusBarHidden
{
   return NO;
}

- (void)initTopView
{
   // 隐藏导航条
   self.navigationController.navigationBar.hidden = YES;
   UIView *topView = [[UIView alloc]init];
   
   
   topView.backgroundColor = [UIColor colorWithRed:97/255.0 green:18/255.0 blue:15/255.0 alpha:1];
   topView.frame = CGRectMake(0, 0, kScreenWidth, 64);
   [self.view addSubview:topView];
   // 添加搜索框
   KTLifeSearchBar *searchBar =[[KTLifeSearchBar alloc] init];
   searchBar.centerX = kScreenWidth*0.5 - 70;
   searchBar.centerY = 60*0.5;
   searchBar.width = 180;
   searchBar.height = 30;
   searchBar.delegate = self;
   self.searchBar = searchBar;
   [topView addSubview:searchBar];
   // 左侧按钮
   UIButton *leftBtn = [[UIButton alloc]init];
   [leftBtn setTitle:@"生活圈" forState:UIControlStateNormal];
   leftBtn.titleLabel.font = [UIFont systemFontOfSize:17];
   [leftBtn setTitleColor:[UIColor colorWithRed:255 green:255 blue:255 alpha:1] forState:UIControlStateNormal];
   leftBtn.frame = CGRectMake(0, 31, 80, 30);
   [topView addSubview:leftBtn];
   
   // 右侧按钮
   UIButton *rightBtn = [[UIButton alloc]init];
   [rightBtn setBackgroundImage:[UIImage imageNamed:@"icon_district"] forState:UIControlStateNormal];
   [rightBtn setBackgroundImage:[UIImage imageNamed:@"icon_map_highlighted"] forState:UIControlStateHighlighted];
   rightBtn.frame = CGRectMake(CGRectGetMaxX(searchBar.frame)+10, 27, 37, 37);
   [topView addSubview:rightBtn];
   

}

// 5个按钮
- (void)initCommonTools
{
   UIView *BGview = [[UIView alloc]init];
   CGFloat X = 0;
   CGFloat Y = 200 + 44;
   BGview.frame = CGRectMake(X, Y,kScreenWidth , 300);
   BGview.backgroundColor = [UIColor colorWithRed:255/255.0 green:255/255.0 blue:255/255.0 alpha:1];
   NSArray *tuPian = [NSArray arrayWithObjects:@"im_car",@"im_shui",@"im_baojie",@"im_chao",@"im_jia",nil];
   for(int i=0;i<5;i++)
   {
      UIButton *btn = [[UIButton alloc]init];
      CGFloat margin = ((kScreenWidth / 3) - 40)/2;
      CGFloat x = margin + ((margin *2) + 40) * i;
      CGFloat y = 10;
      if(i>=3)
      {
         y = 110;
         x = margin + ((margin *2) + 40) * (i - 4);
      }
      CGFloat w = 60;
      CGFloat h = 78;
      btn.frame = CGRectMake(x, y, w, h);
      [btn setImage:[UIImage imageNamed:tuPian[i]] forState:UIControlStateNormal];
      btn.tag = i + 100;
      [btn addTarget:self action:@selector(btnClick:) forControlEvents:UIControlEventTouchUpInside];
      [BGview addSubview:btn];
   }
   [self.view addSubview:BGview];


}


// 。。。。。垃圾代码
- (void)btnClick:(UIButton *)btn
{


   TableViewController *tableVC = [[TableViewController alloc]init];
      UINavigationController* nav = [[UINavigationController alloc]initWithRootViewController:tableVC];
[self presentViewController:nav animated:YES completion:nil];
  // youcuo
}


//图片轮播起//
- (void)initImgPlay{
   
   UIScrollView *scV = [[UIScrollView alloc]init];
   scV.frame = CGRectMake(0, 64, kScreenWidth, kScreenHight *0.3);
   scV.backgroundColor = [UIColor redColor];
   
   [self.view addSubview:scV];
   self.scrollView = scV;

   int count = 6;
   CGFloat imgW = kScreenWidth;
   CGFloat imgH = kScreenHight *0.3;
   for (int i = 0; i < count; i++){
      UIImageView *imageView = [[UIImageView alloc] init];
      NSString *imgName = [NSString stringWithFormat:@"img_%02d", i+1];
      imageView.image = [UIImage imageNamed:imgName];
      //frame
      CGFloat imgY = 0;
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
   
   //    // 进入商品界面
   //    UIButton *enterPru = [UIButton buttonWithType:UIButtonTypeCustom];
   //    [enterPru setTitle:@"" forState:UIControlStateNormal];
   //    [enterPru setTitleColor:[UIColor blackColor] forState:UIControlStateNormal];
   //    enterPru .frame = CGRectMake(30, 400, 80, 40);
   //    [enterPru addTarget:self action:@selector(enterClick) forControlEvents:UIControlEventTouchUpInside];
   //    [self.view addSubview:enterPru];
   
   
   // 添加page
   UIPageControl *pageVC = [[UIPageControl alloc]init];
   pageVC.numberOfPages = count;
//   pageVC.frame = CGRectMake(0, imgH *0.8, 10, 10);
   pageVC.centerX = scV.width*0.5;
   pageVC.centerY = 64 + scV.height *0.93;
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


@end
