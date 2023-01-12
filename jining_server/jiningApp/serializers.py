from rest_framework import serializers
from jiningApp.models import TblShop, TblReview, TblTaste, TblTasteInfo, TblOwner, TblReviewImage, TblCustomer


class ShopSerializer(serializers.ModelSerializer):
    class Meta:
        model = TblShop
        fields = ('shop_id', 'shop_name', 'shop_site_x', 'shop_site_y', 'shop_review_grade', 'shop_review_number')


class TasteSerializer(serializers.ModelSerializer):
    class Meta:
        model = TblTaste
        fields = ('shop', 'info1', 'info2', 'info3', 'info4', 'info5', 'info6', 'info7', 'info8', 'info9',
                  'info10', 'info11', 'info12', 'info13', 'info14', 'info15', 'info16', 'info17', 'info18', 'info19', 'info20')


class TasteInfoSerializer(serializers.ModelSerializer):
    class Meta:
        model = TblTasteInfo
        fields = ('tastekey', 'tastekey')


class CustomerSerializer(serializers.ModelSerializer):
    class Meta:
        model = TblCustomer
        fields = ('customer_email', 'customer_name', 'customer_nickname')


class OwnerSerializer(serializers.ModelSerializer):
    class Meta:
        model = TblOwner
        fields = ('owner_email', 'owner_name', 'owner_nickname', 'shop')


class ReviewSerializer(serializers.ModelSerializer):
    class Meta:
        model = TblReview
        fields = ('review_id', 'shop_id', 'customer_id', 'review_title', 'review_grade', 'review_contents')


class ReviewImageSerializer(serializers.ModelSerializer):
    class Meta:
        model = TblReviewImage
        fields = ('image_id', 'image_path', 'review_id')