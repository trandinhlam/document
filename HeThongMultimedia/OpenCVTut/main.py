import cv2

img = '2-Figure1-1.png'

print("TDLAM DEMO PYTHON OPENCV")

##read

image = cv2.imread(img)
print(image.shape)
## BGR
# cv2.imshow('a', image)
# cv2.waitKey(0)
# cv2.destroyAllWindows()

img2 = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

img2 = cv2.resize(img2, (0, 0), fx=2.25, fy=2.25)

cv2.imshow('a', img2)
cv2.waitKey(0)
cv2.destroyAllWindows()

##write
cv2.imwrite('gray.png', img2)

vid = cv2.VideoCapture(0)

h = vid.get(cv2.CAP_PROP_FRAME_HEIGHT)
print(h)
print(vid.get(cv2.CAP_PROP_IMAGES_LAST))
