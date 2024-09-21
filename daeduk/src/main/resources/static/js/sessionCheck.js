$(document).ready(function () {
    $('#header').load('/header.html', function () {
        updateLoginButton(); // 헤더가 로드된 후 버튼 상태 업데이트
    });

    // 로그인 상태를 확인하고 버튼을 업데이트하는 함수
    function updateLoginButton() {
        var isLoggedIn = $('#loginCheck').val() === 'true'; // 히든 필드에서 값 가져오기
        console.log("로그인 체크: " + isLoggedIn);

        if (isLoggedIn) {
            $('#loginBtn')
                .text('로그아웃')
                .attr('href', '/logout')
                .removeClass('btn btn-primary')
                .addClass('btn btn-primary out');
        } else {
            $('#loginBtn')
                .text('로그인')
                .removeClass('btn btn-primary out')
                .addClass('btn btn-primary');
        }
    }
});