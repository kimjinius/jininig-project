from django.urls import include, path
from rest_framework import routers
from jiningApp.views import ShopViewSet, TasteViewSet, TasteInfoViewSet

router = routers.DefaultRouter()
router.register(r'shop', ShopViewSet)
router.register(r'taste', TasteViewSet)
router.register(r'tasteInfo', TasteInfoViewSet)

urlpatterns = [
    path('', include(router.urls)),
]

