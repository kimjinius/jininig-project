from django.db import models


class TblCustomer(models.Model):
    customer_email = models.CharField(primary_key=True, max_length=40)
    customer_name = models.CharField(max_length=20)
    customer_nickname = models.CharField(unique=True, max_length=20)

    def __str__(self):
        return self.title


class TblOwner(models.Model):
    owner_email = models.CharField(db_column='Owner_email', primary_key=True,
                                   max_length=40)  # Field name made lowercase.
    owner_name = models.CharField(db_column='Owner_name', max_length=20)  # Field name made lowercase.
    owner_nickname = models.CharField(db_column='Owner_nickname', unique=True,
                                      max_length=20)  # Field name made lowercase.
    shop = models.ForeignKey('TblShop', models.DO_NOTHING)

    def __str__(self):
        return self.title


class TblShop(models.Model):
    shop_id = models.AutoField(primary_key=True)
    shop_name = models.CharField(max_length=20)
    shop_site_x = models.CharField(max_length=30)
    shop_site_y = models.CharField(max_length=30)
    shop_review_grade = models.IntegerField()
    shop_review_number = models.IntegerField()

    def __str__(self):
        return self.title


class TblTaste(models.Model):
    shop = models.OneToOneField(TblShop, models.DO_NOTHING, primary_key=True)
    info1 = models.CharField(max_length=20)
    info2 = models.CharField(max_length=20)
    info3 = models.CharField(max_length=20)
    info4 = models.CharField(max_length=20)
    info5 = models.CharField(max_length=20)
    info6 = models.CharField(max_length=20)
    info7 = models.CharField(max_length=20)
    info8 = models.CharField(max_length=20)
    info9 = models.CharField(max_length=20)
    info10 = models.CharField(max_length=20)
    info11 = models.CharField(max_length=20)
    info12 = models.CharField(max_length=20)
    info13 = models.CharField(max_length=20)
    info14 = models.CharField(max_length=20)
    info15 = models.CharField(max_length=20)
    info16 = models.CharField(max_length=20)
    info17 = models.CharField(max_length=20)
    info18 = models.CharField(max_length=20)
    info19 = models.CharField(max_length=20)
    info20 = models.CharField(max_length=20)

    def __str__(self):
        return self.title


class TblTasteInfo(models.Model):
    tastekey = models.AutoField(db_column='tasteKey', primary_key=True)  # Field name made lowercase.
    tastevalue = models.CharField(db_column='tasteValue', max_length=20)  # Field name made lowercase.

    def __str__(self):
        return self.title


class TblReview(models.Model):
    review_id = models.AutoField(primary_key=True)
    shop_id = models.ForeignKey('TblShop', models.DO_NOTHING)
    customer_id = models.ForeignKey('TblCustomer', models.DO_NOTHING)
    review_title = models.CharField(max_length=20)
    review_grade = models.IntegerField()
    review_contents = models.CharField(max_length=100)

    def __str__(self):
        return self.title


class TblReviewImage(models.Model):
    image_id = models.AutoField(primary_key=True)
    image_path = models.CharField(max_length=100)
    review_id = models.ForeignKey('TblReview', models.DO_NOTHING)

    def __str__(self):
        return self.title
