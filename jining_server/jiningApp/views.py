from django.shortcuts import render
from rest_framework import viewsets
from jiningApp.serializers import ShopSerializer, TasteSerializer, TasteInfoSerializer
from jiningApp.models import TblShop, TblTaste, TblTasteInfo


class ShopViewSet(viewsets.ModelViewSet):
    queryset = TblShop.objects.all()
    serializer_class = ShopSerializer


class TasteViewSet(viewsets.ModelViewSet):
    queryset = TblTaste.objects.all()
    serializer_class = TasteSerializer


class TasteInfoViewSet(viewsets.ModelViewSet):
    queryset = TblTasteInfo.objects.all()
    serializer_class = TasteInfoSerializer
