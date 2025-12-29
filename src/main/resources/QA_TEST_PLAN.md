# Mod QA Test Plan: Lucky Blocks

**Mod ID:** `luckyblocks`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-29T02:54:45.654Z
**Total Tests:** 4

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p luckyblocks:random_selection_from_loot_table
/give @p luckyblocks:void_essence
```

## Items

### 🤖 Random Selection From Loot Table Registration

**Command:** `/give @p luckyblocks:random_selection_from_loot_table`

**Steps:**
1. Run: /give @p luckyblocks:random_selection_from_loot_table
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Void Essence Registration

**Command:** `/give @p luckyblocks:void_essence`

**Steps:**
1. Run: /give @p luckyblocks:void_essence
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Random Selection From Loot Table Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","luckyblocks:void_essence"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Random Selection From Loot Table

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Lucky Block Placement

**Command:** `/give @p luckyblocks:lucky_block`

**Steps:**
1. Run: /give @p luckyblocks:lucky_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 2 | [ ] | [ ] |
| Recipes | 1 | [ ] | [ ] |
| Blocks | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_