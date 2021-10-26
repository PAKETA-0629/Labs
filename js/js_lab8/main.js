
function getFullName(user) {
    const [firstName, lastName] = user;

    return [firstName, lastName];
}

function handleThings(opts = {name: "Some Name"}) {
    opts.name = "Some Name";
    return opts;
}

class Queue {

    queue;
    constructor(...args) {
        this.queue = args;
    }

    pop() {
        const value = this.queue[0];
        this.queue.splice(0, 1);
        return value;
    }
}