//建立父控制器器，实现控制器的继承，使得编写一次可以多次使用（进行抽取）
app.controller("baseController",function ($scope) {

    //封装调用分页方法
    $scope.reloadList=function(){//切换页码
        $scope.search( $scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    };

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){-
            $scope.reloadList();//重新加载
        }
    };


    //删除品牌
    $scope.selectIds=[];      //定义一个数组用于存放要删除的品牌对象的id值
    //更新复选框(也就是说在更新selectIds数组中的元素，更新完之后就要根据该数组中的id进行查找并删除元素)
    $scope.updateSelection = function ($event,id) {     //$event是源或者是用来存放事件对象，点击事件，选中事件....，并不是input输入框本身
        if ($event.target.checked){                     //$event.target表示的是input输入框本身，.checked表示看输入框是否被选中
            $scope.selectIds.push(id);
        }else {
            var index = $scope.selectIds.indexOf(id);   //indexOf()方法用于获取指定id在数组中的索引
            $scope.selectIds.splice(index,1);           //该方法用于删除数组中的元素，参数有两个：参数1：表示要删除元素的索引，参数2：表示要删除几个
        }
    };
});