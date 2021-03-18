requestGet = async function (url, json) {
    url += `?json=${json}`;
    const response = await fetch(url, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const obj = JSON.parse(await response.text());
    return obj;
};

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