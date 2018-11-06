function userComponent($view, url) {
    let model = null;
    init();

    function init() {
        //页面加载同步后端数据
        myAjax(url, "GET", null, (users) => {
            model = users;
            render();
        })
    }

    function render() {
        let $tbody = $view.find("tbody");
        $tbody.empty();
        model.forEach((user) => {
            $("<tr>")
                .append($("<td>").text(user.name))
                .append($("<td>").text(user.sex))
                .append($("<td>").text(user.birth))
                .append($("<td>").append($("<img>").attr("src",user.path)))
                .appendTo($tbody);
        })
    }
}

$(function () {
    userComponent($("#userList"), "/users/");
})