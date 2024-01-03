class Solution {

    public String solution(String new_id) {

        //step 1
        new_id = new_id.toLowerCase();

        //step 2
        new_id = new_id.replaceAll("[^a-z0-9.\\-_]", "");

        //step 3
        new_id = new_id.replaceAll("\\.{2,}", ".");

        //step 4
        new_id = new_id.replaceAll("^\\.+", "");
        new_id = new_id.replaceAll("\\.+$", "");

        //step 5
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        //step 6
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^\\.+", "");
            new_id = new_id.replaceAll("\\.+$", "");
        }

        //step 7
        if (new_id.length() < 3) {
            char ch = new_id.charAt(new_id.length() - 1);
            for (int i = 0; i < ch * (3 - new_id.length()); i++) {
                new_id += ch;
            }
        }

        return new_id;
    }
}