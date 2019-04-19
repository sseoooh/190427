var cust = cust || {};
	cust =(()=>{
		let init=()=>{
			onCreate();
		}
		
		let onCreate=()=>{
			setContentView();
		}
		
		let setContentView=()=>{
		}
		
		let modify=()=>{
			$("#right_content").empty();
			$(compo.cust_update()).appendTo('#right_content');
			$('#update_btn').click(function(){
				
				let data ={
					customerId:$('form input[name=id]').val(),
					password:$('form input[name=password]').val(),
					phone:$('form input[name=phone]').val(),
					city:$('form input[name=city]').val(),
					address:$('form input[name=address]').val(),
					postalCode:$('form input[name=postalcode]').val(),
					};
				
				$.ajax({
					url :$.ctx()+'/customers/'+data.customerId,
					type :'PUT',
					data : JSON.stringify(data),
					dataType : 'json',
					contentType : 'application/json',
					success : d=>{
						alert("성공");
					} ,
					error :  e=>{
						alert("실패");
					}
				})
			})//버튼클릭이벤트
		}//modify끝
		
		let join=()=>{
			$('#right_content').empty();
			$(compo.cust_join()).appendTo('#right_content');
			$('#join_btn').click(function(){
				
				let data={
					customerId:$('form input[name=id]').val(),
					customerName:$('form input[name=name]').val(),
					password:$('form input[name=password]').val(),
					ssn:$('form input[name=ssn]').val(),
					phone:$('form input[name=phone]').val(),
					city:$('form input[name=city]').val(),
					address:$('form input[name=address]').val(),
					postalCode:$('form input[name=postalcode]').val(),
					photo:$('form input[name=photo]').val()
				};
				
				$.ajax({
					url : $.ctx()+'/customers',
					type : 'POST',
					data : JSON.stringify(data),
					dataType : 'json',
					contentType : 'application/json',
					success : d=>{
						alert("회원가입성공");
					},
					error : e=>{
						alert("회원가입실패");
					}
				})//ajax끝
			})
		}
		
		let leave=()=>{
			$("#right_content").empty();
			$(compo.cust_leave()).appendTo('#right_content');
			$('#leave_btn').click(function(){
				
				let data={
						customerId:$('form input[name=id]').val(),
						customerName:$('form input[name=name]').val(),
						password:$('form input[name=password]').val(),
						ssn:$('form input[name=ssn]').val()
				};
				
				$.ajax({
					url : $.ctx()+'/customers/'+data.customerId,
					type : 'DELETE',
					data : JSON.stringify(data),
					dataType : 'json',
					contentType : 'application/json',
					success : d=>{
						alert("성공");
					},
					error : e=>{
						alert("실패");
					}
				})
			})//버튼클릭이벤트
		}//let leave끝
		let list=x=>{
			$.getJSON($.ctx()+'/customers/'+ x, d=>{
				$("#right_content").empty();
				let html =  '<table border="2">'
					+'<tr bgcolor="skyblue" valign="middle">'
					+'<th>No</th>'
					+'<th>아이디</th>'
					+'<th>이름</th>'
					+'<th>핸드폰번호</th>'
					+'<th>도시</th>'
					+'<th>주소</th>'
					+'<th>우편번호</th>'
					+'<th>사진</th>'
					+'</tr>';
				$.each(d.list,(i,j)=>{
					alert("j.runm값"+j.rnum);
				html +=	'<tr align="center">'
					+'<td>'+j.rnum+'</td>'
					+'<td>'+j.customerId+'</td>'
					+'<td>'+j.customerName+'</td>'
					+'<td>'+j.phone+'</td>'
					+'<td>'+j.city+'</td>'
					+'<td>'+j.address+'</td>'
					+'<td>'+j.postalCode+'</td>'
					+'<td>'+j.photo+'</td>'
					+'</tr>';
				});
				
				html += '</table>';
				$(html).appendTo('#right_content');
				
		$('<div class="container"><ul id="ul" class="pagination"></ul></div>').appendTo('#right_content');
		let p=0;
		let startPage=1;
		let endPage=5;
		
		for(i=startPage; i<=endPage; i++){
			$('<li><a>'+ i + '</a></li>')
			.appendTo('#ul')
			.click(function(){
				alert('클릭한 페이지번호 : ' + $(this).text());
				list($(this).text());
					
				})
		}
			});
		};
		return{init:init, modify:modify, leave:leave, join:join, list:list};
	})();