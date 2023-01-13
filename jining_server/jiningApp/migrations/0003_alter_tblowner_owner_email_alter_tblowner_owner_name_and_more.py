# Generated by Django 4.1.5 on 2023-01-13 11:44

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('jiningApp', '0002_rename_shop_tblowner_shop_id_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='tblowner',
            name='owner_email',
            field=models.CharField(max_length=40, primary_key=True, serialize=False),
        ),
        migrations.AlterField(
            model_name='tblowner',
            name='owner_name',
            field=models.CharField(max_length=20),
        ),
        migrations.AlterField(
            model_name='tblowner',
            name='owner_nickname',
            field=models.CharField(max_length=20, unique=True),
        ),
        migrations.AlterField(
            model_name='tbltasteinfo',
            name='taste_key',
            field=models.AutoField(primary_key=True, serialize=False),
        ),
        migrations.AlterField(
            model_name='tbltasteinfo',
            name='taste_value',
            field=models.CharField(max_length=20),
        ),
    ]