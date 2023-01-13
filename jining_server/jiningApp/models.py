from django.db import models


class TblCustomer(models.Model):
    customer_email = models.CharField(primary_key=True, max_length=40)
    customer_name = models.CharField(max_length=20)
    customer_nickname = models.CharField(unique=True, max_length=20)

    def __str__(self):
        return self.customer_email


class TblOwner(models.Model):
    owner_email = models.CharField(primary_key=True, max_length=40)
    owner_name = models.CharField(max_length=20)
    owner_nickname = models.CharField(unique=True, max_length=20)  # Field name made lowercase.
    shop_id = models.ForeignKey("TblShop", related_name="shop_owner", on_delete=models.CASCADE)

    def __str__(self):
        return self.owner_email


class TblShop(models.Model):
    shop_id = models.AutoField(primary_key=True)
    shop_name = models.CharField(max_length=20)
    shop_site_x = models.CharField(max_length=30)
    shop_site_y = models.CharField(max_length=30)
    shop_review_grade = models.IntegerField()
    shop_review_number = models.IntegerField()

    def __str__(self):
        return str(self.shop_id)


class TblTaste(models.Model):
    shop_id = models.OneToOneField(TblShop, on_delete=models.CASCADE, primary_key=True)
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
        return str(self.shop_id)


class TblTasteInfo(models.Model):
    taste_key = models.AutoField(primary_key=True)
    taste_value = models.CharField(max_length=20)

    def __str__(self):
        return str(self.taste_key)


class TblReview(models.Model):
    review_id = models.AutoField(primary_key=True)
    shop_id = models.ForeignKey("TblShop", related_name="shop_review", on_delete=models.CASCADE)
    customer_id = models.ForeignKey('TblCustomer', related_name="customer", on_delete=models.CASCADE)
    review_title = models.CharField(max_length=20)
    review_grade = models.IntegerField()
    review_contents = models.CharField(max_length=100)

    def __str__(self):
        return str(self.review_id)


class TblReviewImage(models.Model):
    image_id = models.AutoField(primary_key=True)
    image_path = models.CharField(max_length=100)
    review_id = models.ForeignKey('TblReview', related_name="review", on_delete=models.CASCADE)

    def __str__(self):
        return str(self.image_id)
