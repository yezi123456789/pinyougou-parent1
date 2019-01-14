//定义控制器
app.controller("brandController",function ($scope, $http,$controller,brandService) {

    //控制器之间的继承
    $controller("baseController",{$scope:$scope});      //参数一：表示要继承的控制器的名字；参数2：表示保持两个控制器之间的scope是相同的

    $scope.findAll = function () {
        brandService.findAll().success(function (response) {
            $scope.list = response;
        });
    };

    //分页
    $scope.findPage=function(page,rows){
        brandService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };

    //保存和更新
    $scope.save=function(){
        var object=null;//方法名称
        if($scope.entity.id!=null){//如果有 ID
            object = brandService.update($scope.entity);//则执行修改方法
        }else{
            object = brandService.add($scope.entity);
        }
        object.success(
            function(response){
                if(response.success){//重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    };

    //根据id查询品牌
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };



    //根据上面获取的id数组进行批量删除
    $scope.dele=function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                //根据响应回来的数据进行判断Result对象的success属性是否为true，然后进行列表的刷新
                if (response.success){
                    $scope.reloadList();                //刷新列表
                }
            }
        );
    }

    //用于条件差查询，根据输入的名字和首字母进行
    $scope.searchEntity={};                             //将searchEntity进行初始化为空的值
    $scope.search = function (page,rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.list=response.rows;                              //每页的记录列表
                $scope.paginationConf.totalItems = response.total;      //总记录数
            }
        );
    };




});
