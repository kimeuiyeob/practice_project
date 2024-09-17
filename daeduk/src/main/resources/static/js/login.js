// 모달 스크립트
var loginModal = document.getElementById("loginModal");
var signupModal = document.getElementById("signupModal");
var passwordFindModal = document.getElementById("passwordFindModal");
var loginButton = document.querySelector(".btn.btn-primary");
var closeModalButtons = document.querySelectorAll(".close-modal");

loginButton.addEventListener("click", function () {
    loginModal.style.display = "block";
    document.body.style.overflow = "hidden";
});

closeModalButtons.forEach(function (button) {
    button.addEventListener("click", function () {
        loginModal.style.display = "none";
        signupModal.style.display = "none";
        passwordFindModal.style.display = "none";
        document.body.style.overflow = "auto";
    });
});

window.addEventListener("click", function (event) {
    if (event.target === loginModal || event.target === signupModal || event.target === passwordFindModal) {
        loginModal.style.display = "none";
        signupModal.style.display = "none";
        passwordFindModal.style.display = "none";
        document.body.style.overflow = "auto";
    }
});

const signupLink = document.querySelector(".custom-signup-link");
signupLink.addEventListener("click", function (event) {
    event.preventDefault();
    loginModal.style.display = "none";
    passwordFindModal.style.display = "none";
    signupModal.style.display = "block";
});

const loginLink = document.querySelector(".custom-login-link");
loginLink.addEventListener("click", function (event) {
    event.preventDefault();
    signupModal.style.display = "none";
    passwordFindModal.style.display = "none";
    loginModal.style.display = "block";
});

const forgotPassLink = document.querySelector(".custom-forgot-pass");
forgotPassLink.addEventListener("click", function (event) {
    event.preventDefault();
    loginModal.style.display = "none";
    signupModal.style.display = "none";
    passwordFindModal.style.display = "block";
});

$(document).ready(function () {
    $('#loginForm').submit(function (event) {
        event.preventDefault();
        const email = $('#email').val();
        const password = $('#password').val();
        $.ajax({
            url: '/confirm',
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                email: email,
                password: password
            }),
            success: function (data) {
                if (data.success) {
                    window.location = "/daeduk";
                } else {
                    alert(data.message);
                }
            },
            error: function (request, status, error) {
                alert("Error : " + request.responseText);
            }
        });
    });

    $('#passwordFindForm').submit(function (event) {
        event.preventDefault();
        const findEmail = $('#findEmail').val();

        $('#loadingIndicator').show();
        $('.custom-button-field').hide();

        $.ajax({
            url: '/findEmail',
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                email: findEmail
            }),
            success: function (data) {

                $('#loadingIndicator').hide();

                if (data.success) {
                    alert("이메일로 비밀번호를 보내드렸습니다.");
                    passwordFindModal.style.display = "none";
                    document.body.style.overflow = "auto";
                    $('.custom-button-field').show();
                } else {
                    alert(data.message);
                    $('.custom-button-field').show();
                }
            },
            error: function (request, status, error) {
                $('#loadingIndicator').hide();
                $('.custom-button-field').show();
                alert("Error: " + request.responseText);
            }
        });
    });

    $('#signupForm').submit(function (event) {

        event.preventDefault();

        const email = $('#signupEmail').val().trim();
        const password = $('#signupPassword').val().trim();
        const passwordConfirm = $('#signupPasswordConfirm').val().trim();

        if (!email || !password || !passwordConfirm) {
            alert("모든 필드를 입력해주세요.");
            return;
        }

        if (password !== passwordConfirm) {
            alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
            return;
        }
        if (password.length < 6 || password.length > 16) {
            alert("비밀번호는 6자리 이상 16자리 이하이어야 합니다.");
            return;
        }

        $.ajax({
            url: '/signup',
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                email: email,
                password: password
            }),
            success: function (data) {
                if (data.success) {
                    alert("회원가입이 완료되었습니다.");
                    signupModal.style.display = "none";
                    loginModal.style.display = "none";
                } else {
                    alert(data.message);
                }
            },
            error: function (request, status, error) {
                alert("Error: " + request.responseText);
            }
        });
    });
});