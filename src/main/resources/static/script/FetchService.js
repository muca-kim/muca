// get request : 조회처리
requestGet = async function (url) {
    const response = await fetch(url, {
        method: "GET",
    });
    const obj = JSON.parse(await response.text());
    return obj;
};
// get post : 등록처리
requestPost = async function (url, json) {
    let csrf = $("input[name='_csrf']").val();
    const response = await fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrf
        },
        body: json
    });
    const obj = JSON.parse(await response.text());
    return obj;
};
// put request : 정정처리
requestPut = async function (url, json) {
    let csrf = $("input[name='_csrf']").val();
    const response = await fetch(url, {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrf
        },
        body: json
    });
    const obj = JSON.parse(await response.text());
    return obj;
}
// delete request : 삭제처리
requestDelete = async function (url, json) {
    let csrf = $("input[name='_csrf']").val();
    const response = await fetch(url, {
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrf
        },
        body: json
    });
    const obj = JSON.parse(await response.text());
    return obj;
}