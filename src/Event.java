public enum Event {
    CREATE_PROCESS, //"create"
    EXECUTE_PROCESS, //"execute"
    TERMINATE_PROCESS, //"terminate"
    SENT_TO_READY_QUEUE, //"ready"
    SENT_TO_WAIT_QUEUE, //"wait"
    SENT_TO_CPU, //"cpu"
    INTERRUPTED, //"interrupt"
    CONTEXT_SWITCH //"switch"

}
