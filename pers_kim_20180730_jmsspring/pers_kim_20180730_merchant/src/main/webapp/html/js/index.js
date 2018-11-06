$(function () {
    $("#formList").on("submit", (e) => {
        e.preventDefault();
        let obj = $(e.target).serializeObject();
        let form=new FormData();
        form.append("path",$("#file")[0].files[0]);
        $.ajax({
            url: "/user/upload",
            method: "POST",
            data: form,
            processData: false,
            contentType: false,
            success: (name) => {
                if (name.error) {
                    alert("添加失败")
                } else {
                    // console.log(name);
                    obj.path="http://localhost:9092/upload/"+name;
                    myAjax("/user", "POST", obj, (nc) => {
                        if (nc.error) {
                            alert("添加失败！")
                        } else {
                            alert("添加成功！")
                        }
                    })
                }
            }
        })

    })
})