export function dateFromTimestamp(timestamp) {
    let date = new Date(timestamp);
    return date.toLocaleDateString() + " " + date.toLocaleTimeString();
}

