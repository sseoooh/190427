var auth = auth || {};
auth =(()=>{
	const WHEN_ERR = "호출하는 JS파일을 찾지 못했습니다."
		let init=()=>{
			onCreate();
		}
		let onCreate=()=>{
			setContentView();
		}
		let setContentView=()=>{
			$('#left_content ul').empty();
			$('#left_content h4').text('로그인을해주세요');
			
			$("#right_content").empty();
			$(compo.login_form()).appendTo("#right_content");
			$('form button[type=submit]').click(e=>{
				e.preventDefault();
				login();	
			});
			
			$('form button[type=button]').click(function(){
				cust.join();
			})
		};//setContentView끝
		
		let login=()=>{
			let data = {
					customerId:$('form input[name=uname]').val(),
					password:$('form input[name=psw]').val()};
			
			$.ajax({
				url : $.ctx()+'/customers/'+data.customerId,
				type : 'POST',
				data : JSON.stringify(data),
				dataType : 'json',
				contentType : 'application/json',
				success : d=>{
					if(d.password===data.password){
						alert("로그인성공");
						$("#right_content").empty();
						$(compo.cust_mypage()).appendTo("#right_content");
						
						 $('#left_content ul').empty();
						 $('#left_content h4').text('전서우 고객님 환영합니다');
						
					let arr=[{txt : '노트북샵', name : 'shopping'},
							{txt : '장바구니', name : 'basket'},
							{txt : '구매내역', name : 'perchase'},
							{txt : '정보수정', name : 'modify'},
							{txt : '회원탈퇴', name : 'leave'},
							{txt : '회원목록', name : 'list'}
						];
					 
					$.each(arr,(i,j)=>{
						
						$('<li><a href="#">'+j.txt+'</a></li>')
						.attr('name',j.name)
						.attr('id',j.name)
						.appendTo('#left_content ul')
						.click(function(){
							let that = $(this).attr('name');
							$(this).addClass('active');
							$(this).siblings().removeClass('active');
						switch(that){
						case 'shopping': break;
						case 'basket': break;
						case 'perchase': break;
						case 'modify':
							cust.modify();
							break;
						case 'leave':
							cust.leave();
							break;
						case 'list':
							cust.list(1);
							break;
						}
						})
					})
					}else{
						alert("로그인실패");
					};
				},
				error : e=>{
					alert("실패"+d.customerId);
				}
			});
		}// login끝
		return {init:init};
})();