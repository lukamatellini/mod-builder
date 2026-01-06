# QA Test Plan: Surprise Blocks

Generated: 2026-01-06T23:18:09.675Z
Minecraft Version: 1.21.1
Mod ID: surpriseblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 21 |
| Passed | 12 |
| Failed | 3 |
| Warnings | 3 |
| Skipped | 3 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `surpriseblocks.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Block | `/give @p surpriseblocks:lucky_block_item` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p surpriseblocks:lucky_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
