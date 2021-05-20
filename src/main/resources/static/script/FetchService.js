// get request : 조회처리
requestGet = async function (url) {
    const response = await fetch(url, {
        method: "GET",
    });
    if (response.ok) {
        const result = await response.text();
        try {
            const obj = JSON.parse(result);
            return obj;
        } catch (e) {
            console.log("parsing error: " + result);
        }
    } else {
        console.log("HTTP error: " + response.status);
    }
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
    if (response.ok) {
        const result = await response.text();
        try {
            const obj = JSON.parse(result);
            return obj;
        } catch (e) {
            console.log("parsing error: " + result);
        }
    } else {
        console.log("HTTP error: " + response.status);
    }
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
    if (response.ok) {
        const result = await response.text();
        try {
            const obj = JSON.parse(result);
            return obj;
        } catch (e) {
            console.log("parsing error: " + result);
        }
    } else {
        console.log("HTTP error: " + response.status);
    }

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
    if (response.ok) {
        const result = await response.text();
        try {
            const obj = JSON.parse(result);
            return obj;
        } catch (e) {
            console.log("parsing error: " + result);
        }
    } else {
        console.log("HTTP error: " + response.status);
    }
}