async function addComment(form){
    let data = new FormData(form);

    await fetch('http://localhost:8081/theme/add/comment',{
        method: 'POST',
        body: data
    }).then(r => r.json()).then(data => {
        console.log(data);
    })
    window.location.href = "/theme/" + data.get("theme_id");
}
