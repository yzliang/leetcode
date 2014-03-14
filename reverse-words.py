class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        if s:
            words = s.split()
            words.reverse()
            return ' '.join(words)
        else:
            return ''
