import os
import numpy as np
from glob import glob
import torch
from torch.utils import data
import torchvision
import matplotlib.pyplot as plt

# load file danh dau bounding box cua tung image
from myDataset import MyDataset

txt = np.genfromtxt('./Input/GTSDB/gt.txt', delimiter=';', dtype=None, encoding=None)

image_dict = {}


def load_meta():
    for i in range(0, len(txt)):
        row = txt[i]
        img_name = row[0]
        img_label = row[-1]
        img_bbox = [row[1], row[2], row[3], row[4], img_label]
        if img_name in image_dict:
            image_dict[img_name].append(img_bbox)
        else:
            image_dict[img_name] = [img_bbox]
    print(image_dict['00001.ppm'])
    print(len(image_dict))  # 506 hinh duoc danh dau


# Data distribution
def label_visualize():
    labels_lst = {}
    for i in image_dict:
        for j in image_dict[i][:]:
            for k in range(len(image_dict[i])):
                label = image_dict[i][:][k][-1]
                if label in labels_lst:
                    labels_lst[label] += 1
                else:
                    labels_lst[label] = 1
    labels_lst = sorted(labels_lst.items())
    print(labels_lst)
    xx = []
    yy = []
    for x in labels_lst:
        print(x)
        xx.append(x[0])
        yy.append(x[1])
    print(xx)
    print(yy)
    x_pos = [i for i, _ in enumerate(xx)]
    plt.bar(x_pos, yy, color='green')
    plt.xlabel("Tên label")
    plt.ylabel("Số lượng")
    plt.title("Phân bố label")
    plt.xticks(x_pos, xx)
    plt.savefig('label_visualize.png')
    plt.show()


# Copy only files that are annotated in the gt.txt to imagesf
import shutil


def recopy_annotated_train():
    pt = glob('./Input/GTSDB/Train/IJCNN2013/*.ppm')
    print(len(pt))
    for i in range(len(image_dict)):
        source = r'./Input/GTSDB/Train/IJCNN2013/{}'.format((list(image_dict)[i]))
        dest = r'./Input/new_train/{}'.format((list(image_dict)[i]))
        shutil.copy(source, dest)
    print(len(glob('./Input/new_train/*/ppm')))  # 506 hinh duoc gan nhan


load_meta()
# label_visualize()
# recopy_annotated_train()


##Transform data
import transforms as T


def transform_data(train):
    transforms = []
    transforms.append(T.ToTensor())

    if train:
        transforms.append(T.RandomHorizontalFlip(0.5))

    return T.Compose(transforms)


def train():
    ##Train the Model
    import utils as utils
    from engine import train_one_epoch, evaluate

    os.environ['TORCH_HOME'] = './'
    device = torch.device('cpu')
    num_classes = 44  # 44 classes = 43 + background
    dataset = MyDataset(image_dic=image_dict, transform=transform_data(train=True))
    dataset_test = MyDataset(image_dic=image_dict, transform=transform_data(train=False))

    # split data 400:100 for train:test with dataset ~500 images
    indices = torch.randperm(len(dataset)).tolist()
    dataset = torch.utils.data.Subset(dataset, indices[:-100])
    dataset_test = torch.utils.data.Subset(dataset_test, indices[-100:])

    data_loader_train = torch.utils.data.DataLoader(dataset=dataset, batch_size=2, shuffle=False,
                                                    collate_fn=utils.collate_fn)
    data_loader_test = torch.utils.data.DataLoader(
        dataset=dataset_test, batch_size=2, shuffle=False, collate_fn=utils.collate_fn)

    # model, cần giải thích được các tham số model truyền vào
    model = torchvision.models.detection.fasterrcnn_resnet50_fpn(pretrained=False, progress=True,
                                                                 num_classes=num_classes, pretrained_backbone=True)

    model.to(device)

    # start train
    params = [p for p in model.parameters() if p.requires_grad]
    optimizer = torch.optim.SGD(params, lr=0.0005, momentum=0.9, weight_decay=0.0005)
    learning_rate_scheduler = torch.optim.lr_scheduler.CosineAnnealingWarmRestarts(optimizer, T_0=1, T_mult=2)

    epochs = 1000
    losses = []
    loss_box_reg = []
    loss_rpn_box_reg = []
    loss_classifier = []
    loss_objectness = []
    stat0 = []
    stat1 = []
    stat2 = []
    stat3 = []
    stat4 = []
    stat5 = []
    stat6 = []
    stat7 = []
    stat8 = []
    stat9 = []
    stat10 = []
    stat11 = []
    torch.set_num_threads(4)
    for epoch in range(epochs):
        metrics = train_one_epoch(model, optimizer, data_loader_train, device, epoch, print_freq=50)
        np.save(str(epoch) + 'metric.h5', metrics)

        losses.append(float(str(metrics.meters['loss']).split(" ")[0]))
        loss_box_reg.append(float(str(metrics.meters['loss_box_reg']).split(" ")[0]))
        loss_rpn_box_reg.append(float(str(metrics.meters['loss_rpn_box_reg']).split(" ")[0]))
        loss_classifier.append(float(str(metrics.meters['loss_classifier']).split(" ")[0]))
        loss_objectness.append(float(str(metrics.meters['loss_objectness']).split(" ")[0]))

        learning_rate_scheduler.step()
        # Evaluate on the test dataset
        # _ gives coco_evaL obj from coco_eval.py from CocoEvaluator()
        _, metric_logger = evaluate(model, data_loader_test, device=device)
        # Stat object is from pycocotools' self.stats in summarize()
        # https://github.com/cocodataset/cocoapi/blob/master/PythonAPI/pycocotools/cocoeval.py
        stat = _.coco_eval['bbox'].stats
        # Append all stats
        stat0.append(stat[0])
        stat1.append(stat[1])
        stat2.append(stat[2])
        stat3.append(stat[3])
        stat4.append(stat[4])
        stat5.append(stat[5])
        stat6.append(stat[6])
        stat7.append(stat[7])
        stat8.append(stat[8])
        stat9.append(stat[9])
        stat10.append(stat[10])
        stat11.append(stat[11])

        print('')
        print('==================================================')
        print('')
        print('')
        print('')

    print("Done!")
    print('star0', stat0)
    print('star1', stat1)
    print('star2', stat2)
    print('star3', stat3)
    print('star4', stat4)
    print('star5', stat5)
    print('star6', stat6)
    print('star7', stat7)
    print('star8', stat8)
    print('star9', stat9)
    print('star10', stat10)
    print('star11', stat11)
    print('losses', losses)
    print('loss_box_reg', loss_box_reg)
    print('loss_rpn_box_reg', loss_rpn_box_reg)
    print('loss_classifier', loss_classifier)
    print('loss_objectness', loss_objectness)
    print("Save!")
    np.save('star0', stat0)
    np.save('star1', stat1)
    np.save('star2', stat2)
    np.save('star3', stat3)
    np.save('star4', stat4)
    np.save('star5', stat5)
    np.save('star6', stat6)
    np.save('star7', stat7)
    np.save('star8', stat8)
    np.save('star9', stat9)
    np.save('star10', stat10)
    np.save('star11', stat11)
    np.save('losses', losses)
    np.save('loss_box_reg', loss_box_reg)
    np.save('loss_rpn_box_reg', loss_rpn_box_reg)
    np.save('loss_classifier', loss_classifier)
    np.save('loss_objectness', loss_objectness)

    # save
    torch.save(model, r'./train1000.pkl')

    torch.save(model.state_dict(), 'train1000.pth')
    torch.save({
        'epoch': epoch,
        "model_state_dict": model.state_dict(),
        'optimizer_state_dict': optimizer.state_dict(),
    }, 'ckpt1000.pth')


train()
