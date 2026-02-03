const API_URL = "/api/users";

/* CREATE USER */
document.getElementById("userForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const user = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Create failed");
        }
        return response.json();
    })
    .then(() => {
        loadUsers();
        document.getElementById("userForm").reset();
    })
    .catch(err => showError(err.message));
});

/* LOAD USERS */
function loadUsers() {
    fetch(API_URL)
        .then(response => {
            if (!response.ok) {
                throw new Error("Fetch failed");
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.getElementById("userTableBody");
            tableBody.innerHTML = "";

            data.content.forEach(user => {
                tableBody.innerHTML += `
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>
                            <button type="button" onclick="deleteUser(${user.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;
            });
        })
        .catch(err => showError(err.message));
}

/* DELETE USER */
function deleteUser(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Delete failed");
        }
        loadUsers();
    })
    .catch(err => showError(err.message));
}

/* ERROR HANDLING */
function showError(message) {
    document.getElementById("errorMessage").innerText = message;
}
