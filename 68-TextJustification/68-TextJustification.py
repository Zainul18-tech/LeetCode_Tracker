# Last updated: 08/07/2026, 20:57:30
class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        result = []
        i = 0

        while i < len(words):
            line_length = len(words[i])
            j = i + 1

            while j < len(words) and line_length + len(words[j]) + (j - i) <= maxWidth:
                line_length += len(words[j])
                j += 1

            num_words = j - i
            spaces = maxWidth - line_length

            # Last line or single word line
            if j == len(words) or num_words == 1:
                line = " ".join(words[i:j])
                line += " " * (maxWidth - len(line))
            else:
                space_between = spaces // (num_words - 1)
                extra_spaces = spaces % (num_words - 1)

                line = ""

                for k in range(num_words - 1):
                    line += words[i + k]
                    line += " " * (
                        space_between + (1 if k < extra_spaces else 0)
                    )

                line += words[j - 1]

            result.append(line)
            i = j

        return result