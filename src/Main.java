import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictionary = new HashMap<>();
        Map<String, String[]> dictionaryBig = new HashMap<>();

        dictionary.put("большой", new String[]{"колосальный", "огромный",
                "громадный", "гигантский"});

        dictionary.put("человек",
                new String[]{"персона", "личность",
                        "индивидум"});
        dictionary.put("дом",
                new String[]{"жилище", "хата",
                        "квартира", "недвижимость"});
        dictionary.put("красивый",
                new String[]{"прекрасный", "очаровательный",
                        "симпатичный", "няшный", "привлекательный"});



        Set<String> keys = dictionary.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next().toString();
            String[] values = dictionary.get(key);
            dictionaryBig.put(key, values);
            for (int i =0; i<values.length;i++) {
                String budushiyKlyuch = values[i];
                ArrayList<String> strArr = new ArrayList<>(values.length);
                strArr.addAll(Arrays.asList(values));
                strArr.remove(budushiyKlyuch);
                strArr.add(key);
                String[] newVals = new String[strArr.size()];
                newVals = strArr.toArray(newVals);
                System.out.println(budushiyKlyuch
                        + " - " + Arrays.toString(newVals));
                dictionaryBig.put(budushiyKlyuch, newVals);
            }
        }


        System.out.println("Введите любое слово из словаря: ");

        Scanner s = new Scanner(System.in);
        String sentences = s.nextLine();
        String[] words = sentences.split(" ");
        Random r = new Random();

        for (int i = 0; i < words.length; i++) {
            String[] synonyms = dictionary.get(words[i]);
            if (synonyms != null) {
                int randomN = r.nextInt(synonyms.length);

                System.out.printf(synonyms[randomN] + " ");

            } else {
                System.out.println("Не понял Вас");
            }

        }

    }
}
