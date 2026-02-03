const API_URL = "/api/users";

/* CREATE USER */
document.getElementById("userForm").addEventListener("submit", function (e) {
    e.preventDefault();

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            name: document.getElementById("name").value,
            email: document.getElementById("email").value
        })
    }).then(() => loadUsers());
});

/* LOAD USERS */
function loadUsers() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const body = document.getElementById("userTableBody");
            body.innerHTML = "";

            data.content.forEach(u => {
                body.innerHTML += `
                <tr>
                    <td>${u.name}</td>
                    <td>${u.email}</td>
                    <td>
                        <button type="button" onclick="deleteUser(${u.id})">
                            Delete
                        </button>
                    </td>
                </tr>`;
            });
        });
}

/* DELETE USER */
function deleteUser(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    }).then(() => loadUsers());
}
