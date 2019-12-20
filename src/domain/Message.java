package domain;

public class Message {

    /*private String sender;
    private String receiver;*/

        private Person sender;
        private Person receiver;
        private String content;

        public Message(Person sender, Person receiver, String content) {
                setSender(sender);
                setReceiver(receiver);
                setContent(content);
        }

        public Person getSender() {
                return sender;
        }

        private void setSender(Person sender) {
                this.sender = sender;
        }

        public Person getReceiver() {
                return receiver;
        }

        private void setReceiver(Person receiver) {
                this.receiver = receiver;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }
}
