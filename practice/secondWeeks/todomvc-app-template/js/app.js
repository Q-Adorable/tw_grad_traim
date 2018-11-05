(function (window) {
	'use strict';

	// 添加一条任务/查看任务列表++
	$('.new-todo').bind('keypress', function (event) {
		if (event.keyCode == "13") {
			let labelValue = $('.new-todo').val();
			let html = `
			<li class="addLi">
			    <div class="view">
			    	<input class="toggle" type="checkbox">
				    <label>${labelValue}</label>
			    	<button class="destroy"></button>
				</div>
				<input class="edit" value="Rule the web">
			</li>`;
			$('.todo-list').append(html);
			$(this).val('');
		}
	});

	//标记/取消标记一条任务
	$('.toggle').click(function(){
		if($(this).prop('checked')){
			$(this).parent().parent().addClass('completed');
		}else{
			$(this).parent().parent().removeClass('completed');
		}
	})
	$('.todo-list').on('click','.addLi',function(){
		if($(this).children(":first").children(":first").prop('checked')){
			$(this).addClass('completed');
		}else{
			$(this).removeClass('completed');
		}
	});

	//标记/取消标记所有任务为完成/未完成
	$('#toggle-all').click(function(){
		if($(this).prop('checked')){
			$('.toggle').prop("checked",true);
	//		$('.toggle').attr("checked",true);
			$('.view').parent().addClass('completed');
		}else{
			$('.toggle').prop("checked", false);
//$('.toggle').removeAttr("checked");
			$('.view').parent().removeClass('completed');
		}
	});

	//删除一条任务
	$('.destroy').click(function(){
		$(this).parent().parent().hide();
	});
	$('.todo-list').on('click','.destroy',function(){
		$(this).parent().parent().hide();
	});

	//查看全部任务
	$('.all').click(function(){
		$('.todo-list li').css({"display":"block"});
		$(this).addClass('selected');
		$('.active').removeClass('selected');
		$('.completed').removeClass('selected');
	})

	//查看有效任务
	$('.active').click(function(){
		$('.todo-list li').css({"display":"block"});
		$(".todo-list li[class~='completed']").hide();
		$(this).addClass('selected');
		$('.all').removeClass('selected');
		$('.completed').removeClass('selected');
	})

	//查看已完成任务
	$('.completed').click(function(){
		$('.todo-list li').css({"display":"none"});
		$(".todo-list li[class~='completed']").css({"display":"block"});
		$(this).addClass('selected');
		$('.active').removeClass('selected');
		$('.all').removeClass('selected');

	})

	//删除全部已完成任务
	$('.clear-completed').click(function(){
		$(".todo-list li[class~='completed']").hide();
	})

})(window);
