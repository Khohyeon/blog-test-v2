<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>   

        <div class="container my-3">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Enter title" name="title" id="title">
                </div>

                <div class="form-group">
                    <textarea class="form-control summernote" rows="5" id="content" name="content"></textarea>
                </div>
                <button onclick="save()" type="button" class="btn btn-primary">글쓰기완료</button>
            </form>


        </div>

        <script>
         function save() {
                let data = {
                    "title": $("#title").val(),
                    "content": $("#content").val()
                };
                // console.log(data.title);
                $.ajax({
                    type: "post",
                    url: "/board",
                    data: JSON.stringify(data),
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json"  // default : 응답의 mime 타입으로 유추함
                }).done((res) => {    // 20x 일때
                    console.log(res);
                    alert(res.msg);
                    location.href = "/board";
                }).fail((err) => {    // 40x , 50x 일때
                    console.log(err);
                    alert(err.responseJSON.msg);
                });
            }
            $('.summernote').summernote({
                tabsize: 2,
                height: 400
            });
        </script>

        <%@ include file="../layout/footer.jsp" %>